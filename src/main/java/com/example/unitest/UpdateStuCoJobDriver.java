package com.example.unitest;

import com.example.jobmanager.Studentcojob;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panxiangyu
 * 2021年06月23日22:27
 * UpdateStuCoJob函数的驱动器
 */
@Controller
@RequestMapping("/updateStuCoJob")
@Api(value = "单元测试StudentCoJob类中的updateStuCoJob方法")
public class UpdateStuCoJobDriver {
    @ApiOperation(value = "获取单元测试的结果,返回单元测试结果，例如：{result:['学生信息异常'],right:[true,true]}", response = Map.class)
    @ApiImplicitParam(
            value = "测试类型,等价类:equiv,语句(条件)覆盖测试:statement,路径覆盖测试:path",
            name = "type", dataType = "String",
            paramType = "query"
    )
    @GetMapping("/getResult")
    @ResponseBody
    public Map<String, Object> getResult(String type) {
        switch (type) {
            case "equiv":
                return UpdateStuCoJobUnitTest.UT_TC_002_001_Equiv();
            case "statement":
                return UpdateStuCoJobUnitTest.UT_TC_002_001_Statement();
            default:
                return UpdateStuCoJobUnitTest.UT_TC_002_001_Path();
        }
    }

    @ApiOperation(value = "输入学生编号,兼职状态测试updateStuCoJob方法,返回{result:'**'}", response = Map.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "学生编号", name = "sid", paramType = "query", dataType = "int"),
            @ApiImplicitParam(value = "兼职状态", name = "state", paramType = "query", dataType = "int"),
    })
    @GetMapping("/singleTest")
    @ResponseBody
    public Map<String, String> singleTest(@RequestParam(value = "state", defaultValue = "1") int state, @RequestParam(value = "sid", defaultValue = "1") int sid) {
        Map<String, String> map = new HashMap<>();
        Studentcojob scJob = new Studentcojob();
        scJob.setSid(sid);
        scJob.setState(state);
        map.put("result", StudentCoJobService.updateStuCoJob(scJob));
        return map;
    }
}
