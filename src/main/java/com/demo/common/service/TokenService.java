package com.demo.common.service;

import com.demo.common.Constants;
import com.demo.common.RedisCache;
import com.demo.domain.user.LoginUser;
import com.demo.utils.IdUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class TokenService {

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;



    @Autowired
    private RedisCache redisCache;

    //创建token
    public String createToken(LoginUser loginUser)
    {
        String uuid = IdUtils.randomUUID();
        loginUser.setUuid(uuid);
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY,uuid);
        String userKey = Constants.LOGIN_USER_KEY+uuid;
        redisCache.setCacheObject(userKey,loginUser,30, TimeUnit.MINUTES);
        return createToken(claims);
    }

    public String createToken(Map<String, Object> claims)
    {
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(new Date().getTime() + expireTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;

    }

    //从Token中获取userinfo
    public LoginUser getLoginUser(String token){
        try
        {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            String userKey = Constants.LOGIN_USER_KEY+uuid;
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
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

    public String getToken(HttpServletRequest request){
        String tokenHeader = request.getHeader(header);
        if (tokenHeader != null){
            return tokenHeader.replace(Constants.TOKEN_PREFIX, "");
        }
        return null;
    }
}