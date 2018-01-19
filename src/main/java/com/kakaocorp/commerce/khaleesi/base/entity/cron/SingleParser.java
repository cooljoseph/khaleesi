/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.entity.cron;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Range;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 단일 값이 주어졌을 때 체크한다.
 */
public class SingleParser extends AbstractParser{
    public SingleParser(Range<Integer> range, DurationField type, String cronFieldExp) {
        super(range, type, cronFieldExp);
    }

    @Override
    public boolean matches(LocalDateTime dateTime) throws ParseException {
        boolean numeriCheck = Arrays.asList(cronFieldExp.split(",")).stream()
                .filter(str -> CharMatcher.inRange('0', '9').matchesAllOf(str)) // 숫자로만 되어 있는 값을 찾는다.
                .anyMatch(str -> Integer.valueOf(str).equals(dateTime.get(type.field))) // 입력된 필드와 일치하는 시간이 있으면 True
                ;

        boolean abbreviationCheck = Arrays.asList(cronFieldExp.split(",")).stream()
                .filter(str -> CharMatcher.ascii().matchesAllOf(str)) // 문자만 입력받은 경우
                .anyMatch(str -> Integer.valueOf(getNumByStr(str, type)).equals(dateTime.get(type.field))); // 입력된 문자열에 맞는 시간이 있으면 True

        return numeriCheck || abbreviationCheck;
    }
}
