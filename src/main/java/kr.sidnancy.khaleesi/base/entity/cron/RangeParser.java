/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package kr.sidnancy.khaleesi.base.entity.cron;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 범위형 표현 식을 체크 한다.
 *
 * 1-20,30-40 이런 식도 가능하고
 * MON-FRI, JAN-JUN 이런식도 가능하다.
 */
public class RangeParser extends AbstractParser{

    private static final Pattern NUMERIC_RANGE_PATTERN = Pattern.compile("(\\d+)-(\\d+)");
    private static final Pattern CHAR_RANGE_PATTERN = Pattern.compile("([a-zA-Z]+)-([a-zA-Z]+)");;

    public RangeParser(DurationField type, String cronFieldExp) {
        super(type, cronFieldExp);
    }

    @Override
    public boolean matches(LocalDateTime dateTime) throws ParseException {
        boolean isNumericCheck =
                Arrays.asList(cronFieldExp.split(",")).stream()
                    .filter(str -> {
                        Matcher numericMathcer = NUMERIC_RANGE_PATTERN.matcher(str);
                        if(numericMathcer.matches()){
                            return isMatch(
                                    Integer.valueOf(numericMathcer.group(1)),
                                    Integer.valueOf(numericMathcer.group(2)),
                                    dateTime.get(type.field));
                        }
                        Matcher charMatcher = CHAR_RANGE_PATTERN.matcher(str);
                        if(charMatcher.matches()){
                            return isMatch(Integer.valueOf(getNumByStr(charMatcher.group(1), type)),
                                    Integer.valueOf(getNumByStr(charMatcher.group(2), type)),
                                    dateTime.get(type.field));
                        }
                        return false;
                    }).findAny().isPresent();

        return isNumericCheck ;
    }

    private boolean isMatch(int from, int to, int value){
        if(from != -1 && to != -1 && from <= to && from <= value && value <= to){
            return true;
        }else{
            return false;
        }
    }
}
