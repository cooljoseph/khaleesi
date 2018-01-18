/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package kr.sidnancy.khaleesi.base.entity.cron;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepParser extends AbstractParser{

    private static final Pattern STEP_PATTERN = Pattern.compile("(\\d+|\\*)/(\\d+)");

    public StepParser(Range<Integer> range, DurationField type, String cronFieldExp) {
        super(range, type, cronFieldExp);
    }

    @Override
    public boolean matches(LocalDateTime dateTime) throws ParseException {
        return Arrays.asList(cronFieldExp.split(",")).stream()
                    .filter(str -> {
                        Matcher matcher = STEP_PATTERN.matcher(str);
                        if(matcher.matches()){
                            int start = matcher.group(1).equals("*") ? 0 : Integer.parseInt(matcher.group(1));
                            int step = Integer.parseInt(matcher.group(2));

                            List<Integer> list = Lists.newArrayList();
                            for(int i = start; i <= range.upperEndpoint(); i+= step){
                                list.add(i);
                            }
                            return list.contains(Integer.valueOf(dateTime.get(type.field)));
                        }
                        return false;
                    }).findAny().isPresent();
    }
}
