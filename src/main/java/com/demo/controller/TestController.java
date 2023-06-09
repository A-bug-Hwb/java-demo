package com.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试demo")
@RequestMapping("/test")
public class TestController {


    @GetMapping("/swaggerTest")
    @ApiOperation("swagger测试")
    public String test1(){
        return "swagger测试";
    }
}
