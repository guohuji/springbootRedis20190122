package com.boot.redis.springbootredis.controller;

/*
    @authuor 郭胡记
    @date 2019/1/26 15:10
*/

import com.boot.redis.springbootredis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class loginController {


    @RequestMapping("/")
    public String loginPage() {
        return "success";
    }

//    @PostMapping("/login")
//    @ResponseBody
//    public User indexSuccess(@RequestParam("username") String username,@RequestParam("password") String password){
//        User user = new User();
//        user.setUsername(username);
//        user.setUsername(password);
//        System.out.println(username);
//        return user;
//    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

//    @RequestMapping("/insert")
//    public String insertUser(@RequestParam("username") String username,@RequestParam("password") String password){
//        System.out.println(username+"============="+password);
//        SysUser sysUser = new SysUser();
//        sysUser.setUsername(username);
//        sysUser.setPassword(bCryptPasswordEncoder.encode(password));
//        sysUser.setStatus(1);
//        userDao.save(sysUser);
//        return "index";
//    }@RequestMapping("/insert")
////    public String insertUser(@RequestParam("username") String username,@RequestParam("password") String password){
////        System.out.println(username+"============="+password);
////        SysUser sysUser = new SysUser();
////        sysUser.setUsername(username);
////        sysUser.setPassword(bCryptPasswordEncoder.encode(password));
////        sysUser.setStatus(1);
////        userDao.save(sysUser);
////        return "index";
////    }

    @RequestMapping("/TestUpload")
    public String TestUpload(){
        System.out.println("1111");
        Map<String,Object> map = new HashMap<>();
        return "upload";
    }
}
