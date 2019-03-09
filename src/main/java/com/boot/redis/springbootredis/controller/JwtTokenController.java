package com.boot.redis.springbootredis.controller;

import com.boot.redis.springbootredis.dto.LoginUser;
import com.boot.redis.springbootredis.dto.Token;
import com.boot.redis.springbootredis.service.TokenService;
import com.boot.redis.springbootredis.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/*
    @authuor 郭胡记
    @date 2019/2/5 16:39
*/
@Controller
public class JwtTokenController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/testJwt")
    public void testJwt(HttpServletResponse response){
        LoginUser loginUser = new LoginUser();
        Token token = tokenService.saveToken(loginUser);
        ResponseUtil.responseJson(response, HttpStatus.OK.value(), token);
    }

    @RequestMapping("/testJWTjiexi")
    public void testJWTjiexi(HttpServletResponse response){
//        LoginUser loginUser = tokenService.getLoginUser("eyJhbGciOiJIUzI1NiJ9.eyJMT0dJTl9VU0VSX0tFWSI6IjJiMWJmNDMyLTIyN2YtNDFjNC05ZDQ2LWVlN2RhYTNhOThlMiJ9.JzK4p8nv9MnPzlvIFqFjsvvQcJoSe_UuKrDjR5UZn28");
//        System.out.println(loginUser+"==================");
//        boolean b = tokenService.deleteToken("eyJhbGciOiJIUzI1NiJ9.eyJMT0dJTl9VU0VSX0tFWSI6IjJiMWJmNDMyLTIyN2YtNDFjNC05ZDQ2LWVlN2RhYTNhOThlMiJ9.JzK4p8nv9MnPzlvIFqFjsvvQcJoSe_UuKrDjR5UZn28");
//        System.out.println(b+"-------------------");

    }
}
