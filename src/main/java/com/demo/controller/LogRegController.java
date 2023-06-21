package com.demo.controller;

import com.demo.domain.LogRegPojo.RegisterUser;
import com.demo.domain.UserPojo.UserVo;
import com.demo.service.ILogRegService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户管理")
public class LogRegController {

    @Autowired
    private ILogRegService iLoginService;


    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(@RequestBody UserVo loginUser){
        String token = iLoginService.login(loginUser.getUserName(),loginUser.getPassword());
        return token;
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public String register(@RequestBody RegisterUser registerUser){
        String msg = iLoginService.register(registerUser);
        return msg;
    }
}
