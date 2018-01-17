/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package kr.sidnancy.khaleesi.base.entity.cron;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

public class CronExpression {
//    private static final Range<Integer> MINUTE_RANGE = Range.closed(0, 59);
//    private static final Range<Integer> HOUR_RANGE = Range.closed(0, 23);
//    private static final Range<Integer> DAY_OF_WEEK_RANGE = Range.closed(1, 7);
//    private static final Range<Integer> DAY_OF_MONTH_RANGE = Range.closed(1, 31);
//    private static final Range<Integer> MONTH_RANGE = Range.closed(1, 12);

    private String minuteExp;
    private String hourExp;
    private String dayOfWeekExp;
    private String dayOfMonthExp;
    private String monthExp;

    private List<AbstractParser> minuteParsers = Lists.newArrayList();
    private List<AbstractParser> hourParsers = Lists.newArrayList();
    private List<AbstractParser> dayOfWeekParsers = Lists.newArrayList();
    private List<AbstractParser> dayOfMonthParsers = Lists.newArrayList();
    private List<AbstractParser> monthParsers = Lists.newArrayList();

    // 외부에서 생성자 호출 금지
    private CronExpression(){}

    private CronExpression(String minute, String hour, String dayOfWeek, String dayOfMonth, String month){
        this.minuteExp = minute;
        this.hourExp = hour;
        this.dayOfWeekExp = dayOfWeek;
        this.dayOfMonthExp = dayOfMonth;
        this.monthExp = month;

        // 분 단위 Parser 추가
        this.minuteParsers.add(new AsteriskParser(AbstractParser.DurationField.MINUTE, minuteExp));
        this.minuteParsers.add(new SingleParser(AbstractParser.DurationField.MINUTE, minuteExp));
        this.minuteParsers.add(new RangeParser(AbstractParser.DurationField.MINUTE, minuteExp));

        // 시 단위 Parser 추가
        this.hourParsers.add(new AsteriskParser(AbstractParser.DurationField.HOUR, hourExp));
        this.hourParsers.add(new SingleParser(AbstractParser.DurationField.HOUR, hourExp));
        this.hourParsers.add(new RangeParser(AbstractParser.DurationField.HOUR, hourExp));

        // 요일 단위 Parser 추가
        this.dayOfWeekParsers.add(new AsteriskParser(AbstractParser.DurationField.DAY_OF_WEEK, dayOfWeekExp));
        this.dayOfWeekParsers.add(new SingleParser(AbstractParser.DurationField.DAY_OF_WEEK, dayOfWeekExp));
        this.dayOfWeekParsers.add(new RangeParser(AbstractParser.DurationField.DAY_OF_WEEK, dayOfWeekExp));

        // 일 단위 Parser 추가
        this.dayOfMonthParsers.add(new AsteriskParser(AbstractParser.DurationField.DAY_OF_MONTH, dayOfMonthExp));
        this.dayOfMonthParsers.add(new SingleParser(AbstractParser.DurationField.DAY_OF_MONTH, dayOfMonthExp));
        this.dayOfMonthParsers.add(new RangeParser(AbstractParser.DurationField.DAY_OF_MONTH, dayOfMonthExp));

        // 월 단위 Parser 추가
        this.monthParsers.add(new AsteriskParser(AbstractParser.DurationField.MONTH, monthExp));
        this.monthParsers.add(new SingleParser(AbstractParser.DurationField.MONTH, monthExp));
        this.monthParsers.add(new RangeParser(AbstractParser.DurationField.MONTH, monthExp));
    }

    public static CronExpression newInstance(String minute, String hour, String dayOfWeek, String dayOfMonth, String month){
        return new CronExpression(minute, hour, dayOfWeek, dayOfMonth, month);
    }

    public boolean isMatched() throws ParseException {
        return isMatched(LocalDateTime.now());
    }

    public boolean isMatched(LocalDateTime localDateTime) throws ParseException {
        validate();

        boolean isMinMatched = match(minuteParsers, localDateTime);
        boolean isHourMatched = match(hourParsers, localDateTime);
        boolean isDayOfWeekMatched = "?".equals(dayOfWeekExp) ? true : match(dayOfWeekParsers, localDateTime);
        boolean isDayOfMonthMatched = "?".equals(dayOfMonthExp) ? true : match(dayOfMonthParsers, localDateTime);
        boolean isMonthMatched = match(monthParsers, localDateTime);

        return isMinMatched && isHourMatched && isDayOfWeekMatched && isDayOfMonthMatched && isMonthMatched;
    }

    private boolean match(List<AbstractParser> parsers, LocalDateTime dateTime) throws ParseException {
        boolean isMatch = false;

        for (AbstractParser parser : parsers) {
            if (parser.matches(dateTime)) {
                isMatch = true;
                break;
            }
        }

        return isMatch;
    }

    /**
     * Cron 식 검증을 한다.
     *
     * @return the boolean
     */
    public void validate() throws ParseException{
        if(StringUtils.isEmpty(minuteExp) || StringUtils.isEmpty(hourExp) || StringUtils.isEmpty(dayOfWeekExp) || StringUtils.isEmpty(dayOfMonthExp) || StringUtils.isEmpty(monthExp)){
            throw new ParseException("비어 있는 필드가 있습니다. 확인 바랍니다.", -1);
        }
        if("?".equals(dayOfWeekExp) && "?".equals(dayOfMonthExp)){
            throw new ParseException("일과 요일 둘다 (?) 값이 입력되어 있습니다. 확인 바랍니다.", -1);
        }
        if(!"?".equals(dayOfWeekExp) && !"?".equals(dayOfMonthExp)){
            throw new ParseException("일과 요일 둘 중에 하나는 ?로 설정되어야 합니다. 확인 바랍니다.", -1);
        }
        if("2".equals(monthExp) && CharMatcher.inRange('0', '9').matchesAllOf(dayOfMonthExp)){
            if(Integer.valueOf(dayOfMonthExp) > 29){
                throw new ParseException("2월로 설정하셨으면 일 필드는 1~29 사이의 값만 입력 가능합니다.", -1);
            }
        }
    }
}
