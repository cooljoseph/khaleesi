/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 칼리시 메인 - 사실 필요 없기는 한데 테스트는 해봐야 되니깐..
 *
 * Created by joseph.yoon on 2017. 4. 26..
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class KhaleesiMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(KhaleesiMainApplication.class, args);
    }
}
