package com.boot.redis.springbootredis.controller;

import com.boot.redis.springbootredis.service.JdbcService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JDBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcService jdbcService;

    @RequestMapping("/jdbc")
    public Map<String,Object> jdbc(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM department");
        return maps.get(0);
    }

    @RequestMapping("/insert111")
    public void insert(){
        jdbcService.insert();
    }
}
