package com.example.unitest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author panxiangyu
 * 2021年06月23日20:18
 * JobForStu函数测试的驱动类
 */
@Controller
@RequestMapping("/jobForStu")
@Api(value = "单元测试JobService类的方法jobForStu")
public class JobForStuDriver {
    @ApiOperation(value = "获取单元测试的结果,返回单元测试结果，例如：{result:[{code=500}],right:[true,true]}", response = Map.class)
    @ApiImplicitParam(
            value = "测试类型,等价类:equiv,语句覆盖测试:statement,条件覆盖测试:condition,路径覆盖测试:path",
            name = "type", dataType = "String",
            paramType = "query"
    )
    @GetMapping("/getResult")
    @ResponseBody
    public Map<String,Object> getResult(String type) {
        switch (type) {
            case "equiv":
                return JobForStuUnitTest.UT_TC_001_001_Equiv();
            case "statement":
                return JobForStuUnitTest.UT_TC_001_001_Statement();
            case "condition":
                return JobForStuUnitTest.UT_TC_001_001_Condition();
            default:
                return JobForStuUnitTest.UT_TC_001_001_Path();
        }
    }
    @ApiOperation(value = "输入兼职编号，学生编号测试jobForStu方法", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "兼职编号", name = "busId", paramType = "query",dataType = "String"),
            @ApiImplicitParam(value = "学生编号", name = "sid", paramType = "query",dataType = "int")
    })
    @GetMapping("/singleTest")
    @ResponseBody
    public String singleTest(@RequestParam(value = "busId", defaultValue = "apply") String busId,@RequestParam(value = "sid", defaultValue = "1") int sid) {
        return JobService.jobForStu(busId,sid).toString();
    }
}
