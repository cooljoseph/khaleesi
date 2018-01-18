/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package kr.sidnancy.khaleesi.base.entity.cron;

import com.google.common.collect.Range;

import java.text.ParseException;
import java.time.LocalDateTime;

public class AsteriskParser extends AbstractParser{

    public AsteriskParser(Range<Integer> range, DurationField type, String cronFieldExp) {
        super(range, type, cronFieldExp);
    }

    @Override
    public boolean matches(LocalDateTime dateTime) throws ParseException {
        if ("*".equals(cronFieldExp)) {
            return true;
        }

        return false;
    }
}
