package com.boot.redis.springbootredis.service;

/*
    @authuor 郭胡记
    @date 2019/2/5 22:09
*/

import com.boot.redis.springbootredis.dto.UserDto;
import com.boot.redis.springbootredis.model.SysUser;

public interface UserService {

    SysUser saveUser(UserDto userDto);

    SysUser updateUser(UserDto userDto);

    SysUser getUser(String name);

    void changePassword(String username, String oldPassword, String newPassword);
}
