package com.boot.redis.springbootredis.service;

/*
    @authuor 郭胡记
    @date 2019/2/5 15:02
*/

import com.boot.redis.springbootredis.dto.LoginUser;
import com.boot.redis.springbootredis.dto.Token;

public interface TokenService {

    Token saveToken(LoginUser loginuser);

    //刷新
    void refresh(LoginUser loginUser);

    LoginUser getLoginUser(String token);

    boolean deleteToken(String token);
}
