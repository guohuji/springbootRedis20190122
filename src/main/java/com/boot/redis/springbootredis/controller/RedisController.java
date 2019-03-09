package com.boot.redis.springbootredis.controller;

import com.boot.redis.springbootredis.bean.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String,Map<String,Object>> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "hello")
    public String TestRedis(){
        Map<String,Object> map = new HashMap<>();
        map.put("address","yangxi");
        map.put("phone","10086");
//        Hello hello = new Hello();
//        hello.setId(123);
//        hello.setName("guohuji");
        redisTemplate.opsForValue().set("k2",map);
        return "hello world";
    }

    @RequestMapping(value = "getHello")
    public Map<String,Object> TestGetRedis(){
        Map<String,Object> map = new HashMap<>();
        map.put("map",redisTemplate.opsForValue().get("k2"));
        return map;
    }
}
