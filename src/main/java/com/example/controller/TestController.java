package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class TestController {
    @RequestMapping("/b")
    public String getUser(){
        return "b";
    }
}
