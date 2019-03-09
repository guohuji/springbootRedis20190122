package com.boot.redis.springbootredis.controller;

import com.boot.redis.springbootredis.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/*
    @authuor 郭胡记
    @date 2019/3/1 19:33
*/
@Controller
public class ThymeleafController {

    @RequestMapping("/book/TestThymeleaf")
    public String hello(Model model){
        String name = "郭胡记";
        model.addAttribute("name",name);
        List<User> list = new ArrayList<>();
        User user = new User("郭胡记","123","12345");
        User user1 = new User("郭胡记1","222","22222");
        User user2 = new User("郭胡记2","333","33333");
        list.add(user);
        list.add(user1);
        list.add(user2);
        model.addAttribute("MapName",list);
        return "test";
    }

    @ResponseBody
    @RequestMapping("/book/tesThref")
    public String href(){
        return "OK";
    }

    //1.测试@ModelAttribute(value="")注释返回具体类的方法
    @RequestMapping("/book/modelView111")
    public String view(){
        return "test1";
    }
}
