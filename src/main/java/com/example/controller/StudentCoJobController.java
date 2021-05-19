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

    @RequestMapping(value = "/UpdateEmpList/{id}")//更新学生兼职状态
    public ResponseData UpdateEmpList(@PathVariable() int id){
        return new ResponseData(ExceptionMsg.SUCCESS,StudentCoJobService.UpdateEmpList(id));
    }

    //根据兼职获取兼职列表
    @RequestMapping(value = "/GetEmpList/{jid}")
    public ResponseData GetEmpList(@PathVariable() int jid){
        return new ResponseData(ExceptionMsg.SUCCESS,StudentCoJobService.selectEmpList(jid));
    }

    //根据学生获取兼职列表
    @GetMapping(value = "/GetStudentJobList/{sid}")
    public ResponseData GetStudentJobList(@PathVariable int sid){
        return new ResponseData(ExceptionMsg.SUCCESS,StudentCoJobService.selectStudentJobList(sid));
    }

    //根据公司获取兼职列表
    @GetMapping(value = "/GetBusinessJobList/{bid}")
    public ResponseData GetBusinessJobList(@PathVariable int bid){
        return new ResponseData(ExceptionMsg.SUCCESS,StudentCoJobService.selectBusinessJobList(bid));
    }
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