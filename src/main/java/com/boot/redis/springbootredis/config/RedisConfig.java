package com.boot.redis.springbootredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {


    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate redis = new RedisTemplate();
        redis.setConnectionFactory(redisConnectionFactory);

        GenericJackson2JsonRedisSerializer vauleSerializer =
                new GenericJackson2JsonRedisSerializer();
        redis.setValueSerializer(vauleSerializer);
        redis.setHashValueSerializer(vauleSerializer);
        GenericToStringSerializer<String> keySerializer =
                new GenericToStringSerializer<>(String.class);
        redis.setKeySerializer(keySerializer);
        redis.setHashKeySerializer(keySerializer);
        return redis;
    }
}
