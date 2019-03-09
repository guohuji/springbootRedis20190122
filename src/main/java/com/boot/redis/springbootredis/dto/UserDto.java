package com.boot.redis.springbootredis.dto;

/*
    @authuor 郭胡记
    @date 2019/2/5 22:10
*/

import com.boot.redis.springbootredis.model.SysUser;

import java.util.List;

public class UserDto extends SysUser {

    private static final long serialVersionUID = -184009306207076712L;

    private List<Long> roleIds;

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
