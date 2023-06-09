package com.demo.service.impl;

import com.demo.domain.user.RegisterUser;
import com.demo.domain.user.User;
import com.demo.service.IRegisterService;
import com.demo.service.IUserService;
import com.demo.utils.SecurityUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    private IUserService iUserService;

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
//        else if (iUserService.findUserByUsername(username) != null)
//        {
//            return "保存用户'" + username + "'失败，注册账号已存在";
//        }
        else {
            User user = new User();
            user.setUsername(username);
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
