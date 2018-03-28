/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.config;

import com.kakaocorp.commerce.khaleesi.TestBase;
import org.junit.Test;
import org.springframework.data.redis.core.ListOperations;

import javax.annotation.Resource;

public class EmbeddedRedisConfigurationTests extends TestBase{

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOperations;

    @Test
    public void testRedisServer() {
        listOperations.rightPush("1", "TEST1");
        listOperations.rightPush("1", "TEST2");
        listOperations.rightPush("1", "TEST3");
        System.out.println(listOperations.leftPop("1"));
        System.out.println(listOperations.leftPop("1"));
        System.out.println(listOperations.leftPop("1"));
    }
}
