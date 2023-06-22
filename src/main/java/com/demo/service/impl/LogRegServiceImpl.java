package com.demo.service.impl;

import com.demo.common.service.TokenService;
import com.demo.common.utils.StringUtils;
import com.demo.domain.LogRegPojo.LoginUser;
import com.demo.domain.LogRegPojo.RegisterUser;
import com.demo.domain.UserPojo.UserBo;
import com.demo.service.ILogRegService;
import com.demo.service.IUserService;
import com.demo.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class LogRegServiceImpl implements ILogRegService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IUserService iUserService;

    @Override
    public String login(String username,String password) {
        if (StringUtils.isEmpty(username)){
            return "用户不能为空";
        }
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
                return "用户名或密码错误";
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


    @Override
    public String register(RegisterUser registerUser) {
        String username = registerUser.getUsername();
        String password = registerUser.getPassword();
        String confirmPassword = registerUser.getConfirmPassword();
        if (StringUtils.isEmpty(username))
        {
            return "用户名不能为空";
        }
        else if (StringUtils.isEmpty(password))
        {
            return "用户密码不能为空";
        }
        else if (!password.equals(confirmPassword))
        {
            return "两次密码不一样";
        }
        else if (username.length() > 20
                || username.length() < 2)
        {
            return "账户长度必须在2到20个字符之间";
        }
        else if (password.length() > 20
                || password.length() < 5)
        {
            return "密码长度必须在5到20个字符之间";
        }
        else if (StringUtils.isNotNull(iUserService.findUserByUsername(username)))
        {
            return "保存用户'" + username + "'失败，注册账号已存在";
        }
        else {
            UserBo user = new UserBo();
            user.setUserName(username);
            user.setPassword(SecurityUtils.encryptPassword(password));
            boolean regFlag = iUserService.registerUser(user);
            if (!regFlag)
            {
                return  "注册失败,请联系系统管理人员";
            }
        }
        return "注册成功";
    }
}
