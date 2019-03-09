package com.boot.redis.springbootredis.dao;

import com.boot.redis.springbootredis.model.FileInfo;
import org.apache.ibatis.annotations.*;

import java.io.File;

/*
    @authuor 郭胡记
    @date 2019/1/29 20:15
*/
@Mapper
public interface FileInfoDao {

    @Select("select * from file_info t where t.id = #{id}")
    FileInfo getById(String id);

    @Insert("insert into file_info(id, contentType, size, path, url, type, createTime, updateTime) values(#{id}, #{contentType}, #{size}, #{path}, #{url}, #{type}, now(), now())")
    int save(FileInfo fileInfo);

    @Update("update file_info t set t.updateTime = now() where t.id = #{id}")
    int update(FileInfo fileInfo);

    @Delete("delete from file_info where id = #{id}")
    int delete(String id);

}
