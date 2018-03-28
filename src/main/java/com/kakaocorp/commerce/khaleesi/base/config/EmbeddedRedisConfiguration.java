/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

@Component
@Slf4j
public class EmbeddedRedisConfiguration implements DisposableBean, InitializingBean{

    private RedisServer redisServer;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Embedded Redis Server Starting....");
        this.redisServer = new RedisServer(6379);
        this.redisServer.start();
        log.info("Embedded Redis Server Started....");
    }

    @Override
    public void destroy() throws Exception {
        if(this.redisServer != null){
            log.info("Embedded Redis Server Stopping....");
            this.redisServer.stop();
            log.info("Embedded Redis Server Stopped....");
        }
    }
}
