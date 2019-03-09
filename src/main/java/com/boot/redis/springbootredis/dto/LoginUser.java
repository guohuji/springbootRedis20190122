package com.boot.redis.springbootredis.dto;

/*
    @authuor 郭胡记
    @date 2019/2/5 13:17
*/

import com.boot.redis.springbootredis.model.Permission;
import com.boot.redis.springbootredis.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class LoginUser extends SysUser implements UserDetails {

    private static final long serialVersionUID = -1379274258881257107L;

    private List<Permission> permissions;
    private String token;
    private Long loginTime;
    private Long expireTime;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账户是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return getStatus() != Status.LOCKED;
    }

    //密码是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //账户是否激活
    @Override
    public boolean isEnabled() {
        return true;
    }
}
