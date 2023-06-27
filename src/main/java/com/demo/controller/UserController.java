package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.Result.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@Api(tags = "用户信息")
public class UserController extends BaseController {

    @GetMapping("/getInfo")
    @ApiOperation("获取登录用户信息")
    public AjaxResult getUserInfo(){
        return AjaxResult.success(getLoginUser());
    }
}
