/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package kr.sidnancy.khaleesi.entity.cron;

import kr.sidnancy.khaleesi.base.entity.cron.CronExpression;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CronExpressionTests {
    @Test
    public void asterikAndSingleTest() throws Exception {
        assertThat(CronExpression.newInstance("*", "*", "?", "*", "*")
                .isMatched(LocalDateTime.of(2018, 1, 16, 16, 30))
                , is(true));

        assertThat(CronExpression.newInstance("29", "*", "?", "*", "*")
                        .isMatched(LocalDateTime.of(2018, 1, 16, 16, 30))
                , is(false));

        assertThat(CronExpression.newInstance("29", "13", "2", "?", "*")
                        .isMatched(LocalDateTime.of(2018, 1, 16, 13, 29))
                , is(true));

        assertThat(CronExpression.newInstance("29", "13", "?", "16", "JAN")
                        .isMatched(LocalDateTime.of(2018, 1, 16, 13, 29))
                , is(true));
    }

    @Test
    public void rangeTest() throws ParseException {
        assertThat(CronExpression.newInstance("0-30,40-50", "*", "?", "*", "*")
                        .isMatched(LocalDateTime.of(2018, 1, 16, 16, 30))
                , is(true));

        assertThat(CronExpression.newInstance("30", "16", "MON-FRI", "?", "*")
                        .isMatched(LocalDateTime.of(2018, 1, 16, 16, 30))
                , is(true));

        assertThat(CronExpression.newInstance("30", "16", "MON-FRI", "?", "*")
                        .isMatched(LocalDateTime.of(2018, 1, 20, 16, 30))
                , is(false));

    }
}
