package com.job.demo.controller;

import com.job.demo.result.ExceptionMsg;
import com.job.demo.result.ResponseData;
import com.job.demo.service.StudentcojobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentcojobController {
    @Resource
    private StudentcojobService studentcojobService;

    @PutMapping(value = "/UpdateEmpList/{id}")
    public ResponseData UpdateEmpList(@PathVariable() int id){
        return new ResponseData(ExceptionMsg.SUCCESS,studentcojobService.UpdateEmpList(id));
    }

    @GetMapping(value = "/GetEmpList/{jid}")
    public ResponseData GetEmpList(@PathVariable() int jid){
        return new ResponseData(ExceptionMsg.SUCCESS,studentcojobService.selectEmpList(jid));
    }

    //根据学生获取兼职列表
    @GetMapping(value = "/GetStudentJobList/{sid}")
    public ResponseData GetStudentJobList(@PathVariable int sid){
        return new ResponseData(ExceptionMsg.SUCCESS,studentcojobService.selectStudentJobList(sid));
    }

    //根据公司获取兼职列表
    @GetMapping(value = "/GetBusinessJobList/{bid}")
    public ResponseData GetBusinessJobList(@PathVariable int bid){
        return new ResponseData(ExceptionMsg.SUCCESS,studentcojobService.selectBusinessJobList(bid));
    }
}
