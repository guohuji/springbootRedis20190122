package com.boot.redis.springbootredis.config;

/*
    @authuor 郭胡记
    @date 2019/1/30 21:45
*/

import com.boot.redis.springbootredis.filter.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMwcConfig implements WebMvcConfigurer {


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
//                            .excludePathPatterns("/","/TestWebMvcView");
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/TestWebMvcView").setViewName("upload");
    }


}
