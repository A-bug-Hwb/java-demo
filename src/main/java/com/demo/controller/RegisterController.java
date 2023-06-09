package com.demo.controller;

import com.demo.domain.user.RegisterUser;
import com.demo.service.IRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户管理")
public class RegisterController {

    @Autowired
    private IRegisterService iRegisterService;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public String register(@RequestBody RegisterUser registerUser){
        String msg = iRegisterService.register(registerUser);
        return msg;
    }
}
