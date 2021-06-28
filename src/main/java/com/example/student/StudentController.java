package com.example.jobmanager;

import com.example.student.Student;
import com.example.student.StudentService;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student-manager")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
@Api(tags="学生管理接口")
public class StudentController {
    @Resource
    private StudentService studentService;

    //查询学生是否存在
    @ApiOperation(value = "查询学生是否存在")
    @PostMapping(value = "/isuser/{openid}")
    public ResponseData isUser(@PathVariable String openid){
        return new ResponseData(ExceptionMsg.SUCCESS, studentService.isUser(openid));
    }
    //获取学生信息
    @ApiOperation(value = "获取学生信息")
    @PostMapping(value = "/get-info/{openid}")
    public ResponseData getInfo(@PathVariable String openid){
        return new ResponseData(ExceptionMsg.SUCCESS, studentService.getInfo(openid));
    }

    //添加学生信息
    @ApiOperation(value = "添加学生信息")
    @PostMapping(value = "/add-student")
    public ResponseData addStudent(Student student){
        studentService.addStudent(student);
        return new ResponseData(ExceptionMsg.SUCCESS, "very good");
    }

    //修改学生信息
    @ApiOperation(value = "修改学生信息")
    @PostMapping(value = "/update-student")
    public ResponseData updateStudent(Student student){
        studentService.updateStudent(student);
        return new ResponseData(ExceptionMsg.SUCCESS, "very good");
    }
}