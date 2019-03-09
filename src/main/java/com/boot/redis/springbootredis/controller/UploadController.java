package com.boot.redis.springbootredis.controller;

import com.boot.redis.springbootredis.model.FileInfo;
import com.boot.redis.springbootredis.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/*
    @authuor 郭胡记
    @date 2019/1/29 19:46
*/
@RestController
public class UploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public FileInfo upload(MultipartFile file) throws IOException {
        return fileService.save(file);
    }

    @DeleteMapping("/files/{id}")
    public void delete(@PathVariable("id") String id){
        fileService.delete(id);
    }
}
