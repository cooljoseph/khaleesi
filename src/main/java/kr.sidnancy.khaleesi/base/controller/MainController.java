package kr.sidnancy.khaleesi.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joseph.yoon on 2017. 4. 26..
 */
@RestController
public class MainController {

    @RequestMapping("/greetings")
    public String greetings(){
        return "hello";
    }
}
