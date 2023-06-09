package com.demo.service.impl;

import com.demo.common.service.TokenService;
import com.demo.domain.user.LoginUser;
import com.demo.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public String login(String username,String password) {

        // 用户验证
        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        }catch (Exception e){
            // 账号过期
            if (e instanceof AccountExpiredException) {
                return "账号过期";
            }
            // 密码错误
            else if (e instanceof BadCredentialsException) {
                return "密码错误";
            }
            // 密码过期
            else if (e instanceof CredentialsExpiredException) {
                return "密码过期";
            }
            // 账号不可用
            else if (e instanceof DisabledException) {
                return "账号不可用";
            }
            //账号锁定
            else if (e instanceof LockedException) {
                return "账号锁定";
            }
            // 用户不存在
            else if (e instanceof InternalAuthenticationServiceException) {
                return "用户不存在";
            }
            // 其他错误
            else{
                return "未知异常";
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }
}
