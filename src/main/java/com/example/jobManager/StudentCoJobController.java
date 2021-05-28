package com.example.jobManager;

import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.Tags;

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
}
