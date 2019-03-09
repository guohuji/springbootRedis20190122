package com.boot.redis.springbootredis.service.Impl;

/*
    @authuor 郭胡记
    @date 2019/2/5 22:13
*/

import com.boot.redis.springbootredis.dao.UserDao;
import com.boot.redis.springbootredis.dto.UserDto;
import com.boot.redis.springbootredis.model.SysUser;
import com.boot.redis.springbootredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    private UserDao userDao;

    @Override
    public SysUser saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public SysUser updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public SysUser getUser(String name) {
//        return userDao.getUser(name);
        return null;
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {

    }
}
