package com.boot.redis.springbootredis.service;

/*
    @authuor 郭胡记
    @date 2019/1/29 19:53
*/

import com.boot.redis.springbootredis.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    FileInfo save(MultipartFile file) throws IOException;

    void delete(String id);
}
