package com.example.Interest;

import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interest")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
@Api(tags = "收藏管理接口")
public class InterestController {
    @Autowired
    private InterestService interestService;

    @ApiOperation(value = "查询某个学生收藏的兼职")
    @GetMapping("/{sid}")
    public ResponseData getStuInterest(@PathVariable int sid){
        return new ResponseData(ExceptionMsg.SUCCESS, interestService.getStuInterest(sid));
    }

    @ApiOperation(value = "学生收藏兼职")
    @PostMapping(value = "/add")
    public ResponseData addInterest(Interest interest){
        interestService.addInterest(interest);
        return new ResponseData(ExceptionMsg.SUCCESS,interest);
    }

    @ApiOperation(value = "学生取消收藏兼职")
    @PostMapping(value = "/delete")
    public ResponseData deleteInterest( int sid, String busid){
        interestService.deleteInterest(sid,busid);
        return new ResponseData(ExceptionMsg.SUCCESS,busid);
    }
}
