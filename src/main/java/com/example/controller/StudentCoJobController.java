package com.example.controller;

import com.example.entity.Job;
import com.example.entity.Studentcojob;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import com.example.service.StudentCoJobService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/StuCoJob")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class StudentCoJobController {
    @Resource
    private StudentCoJobService StudentCoJobService;

    //学生报名兼职
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addJob(Studentcojob scjob){
        StudentCoJobService.addStuCoJob(scjob);
        return new ResponseData(ExceptionMsg.SUCCESS,scjob);
    }
    //学生兼职更新
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseData updateJob(Studentcojob scjob){
        StudentCoJobService.updateStuCoJob(scjob);
        return new ResponseData(ExceptionMsg.SUCCESS,scjob);
    }
}
