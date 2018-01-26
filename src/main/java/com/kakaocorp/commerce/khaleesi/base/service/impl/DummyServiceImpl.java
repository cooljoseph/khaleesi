/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.service.impl;

import com.kakaocorp.commerce.khaleesi.base.service.DummyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DummyServiceImpl implements DummyService{
    @Override
    @Async
    public CompletableFuture<String> dummy()  {
        return CompletableFuture.supplyAsync(() -> {
            log.debug("Start!!!");
            try {
                Thread.sleep(RandomUtils.nextInt(1000, 10000));
                log.debug("Done!!");
                return "Dummy";
            } catch (InterruptedException e) {
                log.error(ExceptionUtils.getStackTrace(e));
                return "error";
            }
        });
    }
}
