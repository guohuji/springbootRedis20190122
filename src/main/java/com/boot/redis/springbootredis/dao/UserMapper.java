package com.boot.redis.springbootredis.dao;

import com.boot.redis.springbootredis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
    @authuor 郭胡记
    @date 2019/2/17 17:53
*/
@Mapper
public interface UserMapper {

    public User selectUser(Integer id);

    public User selectUserStep(Integer id);

    public List<User> selectUserCollectionStep(Integer id);
}
