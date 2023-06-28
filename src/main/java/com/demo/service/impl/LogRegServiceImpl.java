package com.demo.service.impl;

import com.demo.common.exception.LoginException;
import com.demo.common.exception.ServiceException;
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
        // 用户验证
        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        }catch (Exception e){
            // 账号过期
            if (e instanceof AccountExpiredException) {
                throw new LoginException("账号过期");
            }
            // 密码错误
            else if (e instanceof BadCredentialsException) {
                throw new LoginException("用户名或密码错误");
            }
            // 密码过期
            else if (e instanceof CredentialsExpiredException) {
                throw new LoginException("密码过期");
            }
            // 账号不可用
            else if (e instanceof DisabledException) {
                throw new LoginException("账号不可用");
            }
            //账号锁定
            else if (e instanceof LockedException) {
                throw new LoginException("账号锁定");
            }
            // 用户不存在
            else if (e instanceof InternalAuthenticationServiceException) {
                throw new LoginException("用户不存在");
            }
            // 其他错误
            else{
                throw new ServiceException("未知异常");
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }


    @Override
    public boolean register(RegisterUser registerUser) {
        String username = registerUser.getUsername();
        String password = registerUser.getPassword();
        String confirmPassword = registerUser.getConfirmPassword();
        if (!password.equals(confirmPassword))
        {
            throw new ServiceException("两次密码不一样");
        }
        else if (StringUtils.isNotNull(iUserService.findUserByUsername(username)))
        {
            throw new ServiceException("保存用户'" + username + "'失败，注册账号已存在");
        }
        else {
            UserBo user = new UserBo();
            user.setUserName(username);
            user.setPassword(SecurityUtils.encryptPassword(password));
            boolean regFlag = iUserService.registerUser(user);
            if (!regFlag)
            {
                throw new ServiceException("注册失败,请联系系统管理人员");
            }
        }
        return true;
    }
}
