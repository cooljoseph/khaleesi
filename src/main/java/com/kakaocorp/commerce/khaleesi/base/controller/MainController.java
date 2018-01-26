/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kakaocorp.commerce.khaleesi.base.entity.User;
import com.kakaocorp.commerce.khaleesi.base.entity.Views;
import com.kakaocorp.commerce.khaleesi.base.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

/**
 * 일단 테스트 중
 *
 * Created by joseph.yoon on 2017. 4. 26..
 */
@Controller
public class MainController {

    @Autowired
    private DummyService dummyService;

    @RequestMapping("/greetings")
    @ResponseBody
    public String greetings(){
        return "hello user";
    }

    @JsonView(Views.Public.class)
    @RequestMapping("/user")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("PUBLIC");
        user.setInnerName("INNER");
        return user;
    }

    @JsonView(Views.Internal.class)
    @RequestMapping("/inner/user")
    @ResponseBody
    public User getInnerUser(){
        User user = new User();
        user.setId(1);
        user.setName("PUBLIC");
        user.setInnerName("INNER");
        return user;
    }

    @RequestMapping("/")
    public String main(ModelMap mm){
        mm.addAttribute("msg", "WELCOME");
        return "main";
    }

    @RequestMapping("/dummy")
    @ResponseBody
    public DeferredResult<ResponseEntity<String>> dummy(){
        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>();
        dummyService.dummy().whenCompleteAsync((result, throwable) -> deferredResult.setResult(ResponseEntity.ok(result)));
        return deferredResult;
    }
}
