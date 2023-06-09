package com.demo.controller;

import com.demo.domain.user.User;
import com.demo.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户管理")
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(@RequestBody User loginUser){
        String token = iLoginService.login(loginUser.getUsername(),loginUser.getPassword());
        return token;
    }
}
