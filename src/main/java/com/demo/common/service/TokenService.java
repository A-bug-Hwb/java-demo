package com.demo.common.service;

import com.demo.common.RedisCache;
import com.demo.domain.user.LoginUser;
import com.demo.utils.IdUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class TokenService {
    public static final String TOKEN_HEADER="Authorization"; //token请求头
    public static final String TOKEN_PREFIX="Bearer";//token前缀
    public static final long EXPIRATION=60*60*1000; //token有效期
    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";
    public static final String HEADER_STRING="Passport"; //配置token在http heads中的键值
    public static final String SECRET_KEY="piconjo_secret"; //应用密钥


    @Autowired
    private RedisCache redisCache;

    //创建token
    public String createToken(LoginUser loginUser)
    {
        String uuid = IdUtils.randomUUID();
        loginUser.setUuid(uuid);
        Map<String, Object> claims = new HashMap<>();
        claims.put(LOGIN_USER_KEY,uuid);
        String userKey = LOGIN_USER_KEY+uuid;
        redisCache.setCacheObject(userKey,loginUser,30, TimeUnit.MINUTES);
        return createToken(claims);
    }

    public String createToken(Map<String, Object> claims)
    {
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(new Date().getTime() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
        return token;

    }

    //从Token中获取userinfo
    public LoginUser getLoginUser(String token){
        try
        {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            String uuid = (String) claims.get(LOGIN_USER_KEY);
            String userKey = LOGIN_USER_KEY+uuid;
            LoginUser user = redisCache.getCacheObject(userKey);
            return user;
        }
        catch (Exception e)
        {
        }
        return  null;
    }

    //校验Token是否过期
    public boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }
}