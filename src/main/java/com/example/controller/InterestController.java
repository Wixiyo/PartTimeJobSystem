package com.example.controller;

import com.example.entity.Interest;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import com.example.service.InterestService;
import com.example.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interest")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class InterestController {
    @Autowired
    private InterestService interestService;

    @RequestMapping("/{sid}")//查询某个学生收藏的兼职
    public ResponseData getStuInterest(@PathVariable int sid){
        return new ResponseData(ExceptionMsg.SUCCESS, interestService.getStuInterest(sid));
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseData addInterest(Interest interest){
        interestService.addInterest(interest);
        return new ResponseData(ExceptionMsg.SUCCESS,interest);
    }

}
