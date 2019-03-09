package com.boot.redis.springbootredis.service.Impl;

/*
    @authuor 郭胡记
    @date 2019/2/5 15:12
*/

import com.boot.redis.springbootredis.dto.LoginUser;
import com.boot.redis.springbootredis.dto.Token;
import com.boot.redis.springbootredis.service.TokenService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.SignatureAlgorithm;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections4.MapUtils;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${token.jwtSecret}")
    private String jwtSecret;
    @Value("${token.expire.seconds}")
    private Integer expireSeconds;
    @Autowired
    private RedisTemplate<String,LoginUser> redisTemplate;

    private static Key KEY = null;
    private static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

    @Override
    public Token saveToken(LoginUser loginuser) {
        loginuser.setToken(UUID.randomUUID().toString());
        cacheLoginUser(loginuser);

        String jwtToken = createJWTToken(loginuser);
        return new Token(jwtToken,loginuser.getLoginTime());
    }

    private String createJWTToken(LoginUser loginuser) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("LOGIN_USER_KEY",loginuser.getToken());

        String jwtToken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,getKeyInstance()).compact();
        return jwtToken;
    }

    private void cacheLoginUser(LoginUser loginuser) {
        loginuser.setLoginTime(System.currentTimeMillis());
        loginuser.setExpireTime(loginuser.getLoginTime() + expireSeconds * 1000);
        redisTemplate.boundValueOps(getTokenKey(loginuser.getToken())).set(loginuser, expireSeconds, TimeUnit.SECONDS);
    }

    @Override
    public void refresh(LoginUser loginUser) {
        cacheLoginUser(loginUser);
    }

    @Override
    public LoginUser getLoginUser(String token) {
        String uuid = getUUIDFromJWT(token);
        if(uuid != null){
            return redisTemplate.boundValueOps(getTokenKey(uuid)).get();
        }
        return null;
    }

    @Override
    public boolean deleteToken(String token) {
        String uuid = getUUIDFromJWT(token);
        if(uuid != null){
            String key = getTokenKey(uuid);
            LoginUser loginUser = redisTemplate.opsForValue().get(key);
            if(loginUser != null){
                redisTemplate.delete(key);

                return true;
            }
        }
        return false;
    }

    private Key getKeyInstance(){
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
        KEY = new SecretKeySpec(apiKeySecretBytes,SignatureAlgorithm.HS256.getJcaName());
        return KEY;
    }

    private String getTokenKey(String uuid){
        return "tokens:" + uuid;
    }

    private String getUUIDFromJWT(String jwtToken){
        if("null".equals(jwtToken) || StringUtils.isBlank(jwtToken)){
            return null;
        }
        try{
            //解析Token
                Map<String,Object> jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwtToken).getBody();
                return MapUtils.getString(jwtClaims,LOGIN_USER_KEY);
        }catch (Exception e){
                e.printStackTrace();
        }

        return null;
    }
}
