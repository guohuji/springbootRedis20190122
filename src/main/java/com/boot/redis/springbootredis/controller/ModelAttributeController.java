package com.boot.redis.springbootredis.controller;

import com.boot.redis.springbootredis.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/*
    @authuor 郭胡记
    @date 2019/3/3 22:57
*/
@Controller
public class ModelAttributeController {

    private List<User> userList = null;
    //model.attribute("AAA",loginName)
//    @ModelAttribute("AAA")
//    public String userModel1(@RequestParam("loginName") String loginName){
//        return loginName;
//    }

    public ModelAttributeController(){
        userList = new ArrayList<>();
        User user1 = new User("张三","123","10086");
        User user2 = new User("李四","888","10000");
        userList.add(user1);
        userList.add(user2);
    }
//    @ModelAttribute
//    public User userModel2(@RequestParam("loginName") String loginName,
//                           @RequestParam("password") String password){
//        return find(loginName,password);
//    }

    private User find(String loginName, String password) {
        for (User user:userList){
            if(user.getName().equals(loginName) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

//    @ModelAttribute
//    public void modelAttribute3(@RequestParam("loginName") String loginName,
//                                @RequestParam("password") String password,
//                                Model model){
//        model.addAttribute("A",loginName);
//        model.addAttribute("B",password);
//    }

//    @ModelAttribute(value="testKey")
//    @RequestMapping("/login4")
//    public String login4(){
//        return "testValue";
//    }

    @ModelAttribute(value="userKey")
    public User userModel5(@RequestParam("loginName") String loginName,
                           @RequestParam("password") String password){
        User user = new User();
        user.setName(loginName);
        user.setPassword(password);
        return user;
    }

    @RequestMapping(value="/book/login5")
    public String login5(@ModelAttribute("userKey") User user){
        user.setPhone("10086");
        return "result";
    }

    @RequestMapping(value="/book/login1")
    public String login1(){
        return "result";
    }

}
