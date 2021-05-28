package com.example.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "测试接口")
public class TestController {
    @GetMapping("")
    public String getUser(){
        return "hello world";
    }
}
