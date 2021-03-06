package com.boot.redis.springbootredis.dto;

/*
    @authuor 郭胡记
    @date 2019/2/7 16:41
*/

import java.io.Serializable;

public class ResponseInfo implements Serializable {

    private static final long serialVersionUID = -4417715614021482064L;

    private String code;
    private String message;

    public ResponseInfo() {
    }

    public ResponseInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
