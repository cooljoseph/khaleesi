package kr.sidnancy.khaleesi.base.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kr.sidnancy.khaleesi.base.entity.User;
import kr.sidnancy.khaleesi.base.entity.Views;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by joseph.yoon on 2017. 4. 26..
 */
@Controller
public class MainController {

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
        return "welcome";
    }
}
