/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 베이스 테스트
 *
 * Created by joseph.yoon on 2017. 4. 26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestBase {
    @Test
    public void name() {
        assertThat(true, is(true));
    }
}
