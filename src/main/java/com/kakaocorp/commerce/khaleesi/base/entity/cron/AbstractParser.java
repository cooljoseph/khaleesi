/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.entity.cron;

import com.google.common.collect.Range;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractParser {

    protected DurationField type;
    protected String cronFieldExp;
    protected Range<Integer> range;

    private static final List<String> WEEK_ABBREVIATIONS = Arrays.asList("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN");
    private static final List<String> MONTH_ABBREVIATIONS = Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC");

    public AbstractParser(Range<Integer> range, DurationField type, String cronFieldExp) {
        this.range = range;
        this.type = type;
        this.cronFieldExp = cronFieldExp;
    }

    abstract public boolean matches(LocalDateTime dateTime) throws ParseException;

    protected int getNumByStr(String input, DurationField type){
        if(type.equals(DurationField.DAY_OF_WEEK)){
            return WEEK_ABBREVIATIONS.indexOf(input.toUpperCase()) + 1;
        }else if(type.equals(DurationField.MONTH)){
            return MONTH_ABBREVIATIONS.indexOf(input.toUpperCase()) + 1;
        }else {
            return -1;
        }
    }

    public enum DurationField {

        SECOND(ChronoField.SECOND_OF_MINUTE, "second"),
        MINUTE(ChronoField.MINUTE_OF_HOUR, "minute"),
        HOUR(ChronoField.HOUR_OF_DAY, "hour"),
        DAY_OF_WEEK(ChronoField.DAY_OF_WEEK, "day-of-week"),
        DAY_OF_MONTH(ChronoField.DAY_OF_MONTH, "day-of-month"),
        MONTH(ChronoField.MONTH_OF_YEAR, "month");

        final ChronoField field;
        final String name;
//        final Range<Integer> range;

        DurationField(ChronoField field, String name) {
            this.field = field;
            this.name = name;
//            this.range = range;
        }
    }
}
