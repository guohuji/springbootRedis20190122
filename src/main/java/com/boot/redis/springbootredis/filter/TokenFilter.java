package com.boot.redis.springbootredis.filter;

/*
    @authuor 郭胡记
    @date 2019/2/7 14:56
*/

import com.boot.redis.springbootredis.dto.LoginUser;
import com.boot.redis.springbootredis.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenFilter extends OncePerRequestFilter {

    private static final String TOKEN_KEY ="token";

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserDetailsService userDetailsService;

    private static final Long MINUTES_10 = 10 * 60 * 1000L;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        System.out.println(token+"************************");
        if(StringUtils.isNotBlank(token)){
            LoginUser loginUser = tokenService.getLoginUser(token);
            if(loginUser != null){
                loginUser = checkLoginTime(loginUser);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }

    private LoginUser checkLoginTime(LoginUser loginUser) {
        Long expireTime = loginUser.getExpireTime();
        Long currentTime = System.currentTimeMillis();
        if(expireTime - currentTime <= MINUTES_10){
            String token = loginUser.getToken();
            loginUser = (LoginUser)userDetailsService.loadUserByUsername(loginUser.getUsername());
            loginUser.setToken(token);
            tokenService.refresh(loginUser);
        }
        return loginUser;
    }

    public static String getToken(HttpServletRequest request) {
        String token = request.getParameter(TOKEN_KEY);
        if(StringUtils.isBlank(token)){
            token = request.getHeader(TOKEN_KEY);
        }
        System.out.println(token+"getToken+++++++++++++++++++++++++");
        return token;
    }

}
