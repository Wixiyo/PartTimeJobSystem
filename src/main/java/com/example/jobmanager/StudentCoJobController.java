package com.example.jobmanager;

import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/StuCoJob")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
@Api(tags="报名管理接口")
public class StudentCoJobController {
    @Resource
    private StudentCoJobService StudentCoJobService;

    //学生报名兼职
    @ApiOperation(value = "学生报名兼职")
    @PostMapping(value = "/add")
    public ResponseData addJob(Studentcojob scjob){
        StudentCoJobService.addStuCoJob(scjob);
        return new ResponseData(ExceptionMsg.SUCCESS,scjob);
    }
    //学生兼职更新
    @ApiOperation(value = "学生兼职更新")
    @PostMapping(value = "/update")
    public ResponseData updateJob(Studentcojob scjob){
        StudentCoJobService.updateStuCoJob(scjob);
        return new ResponseData(ExceptionMsg.SUCCESS,scjob);
    }

    //搜索学生兼职
    @ApiOperation(value = "搜索学生兼职")
    @PostMapping(value = "/search/{sid}/{state}")
    public ResponseData searchJobsOfStudent(@PathVariable int sid, @PathVariable int state){
        return new ResponseData(ExceptionMsg.SUCCESS, StudentCoJobService.searchJobsOfStudent(sid, state));
    }

    //搜索兼职报名的学生
    @ApiOperation(value = "搜索兼职报名的学生")
    @PostMapping(value = "/search-stu/{busid}")
    public ResponseData searchStudentsOfJob(@PathVariable String busid){
        return new ResponseData(ExceptionMsg.SUCCESS, StudentCoJobService.searchStudentsOfJob(busid));
    }
}
