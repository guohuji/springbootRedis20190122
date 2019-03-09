package com.boot.redis.springbootredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Transactional
    public void insert(){
        jdbcTemplate.update("INSERT INTO department(departmentName) values(?)","CCC");
        //int a = 1 / 0;
        jdbcTemplate.update("INSERT INTO department(departmentName) values(?)","DDD");
    }
}
