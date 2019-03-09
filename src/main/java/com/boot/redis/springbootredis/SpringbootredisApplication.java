package com.boot.redis.springbootredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.boot.redis.springbootredis.mapper")
@SpringBootApplication
public class SpringbootredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootredisApplication.class, args);
    }

}

