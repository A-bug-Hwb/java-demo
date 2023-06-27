package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.annotate.LogStorage;
import com.demo.domain.LogRegPojo.RegisterUser;
import com.demo.domain.UserPojo.UserVo;
import com.demo.service.ILogRegService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public JSONObject login(@RequestBody UserVo loginUser){
        String token = iLoginService.login(loginUser.getUserName(),loginUser.getPassword());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("data",token);
        return jsonObject;
    }

    @LogStorage
    @PostMapping("/register")
    @ApiOperation("用户注册")
    @PreAuthorize("@ac.hasPermi('system:user:list')")
//    @DataSource(DataSourceType.SLAVE)
    public String register(@RequestBody RegisterUser registerUser){
        String msg = iLoginService.register(registerUser);
        return msg;
    }
}
