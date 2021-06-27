package com.example.unitest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author panxiangyu
 * 2021年06月24日0:15
 * AnalyseTags驱动器
 */
@Controller
@RequestMapping("/analyseTags")
@Api(value = "AnalyseTagsService类中方法analyseTags单元测试")
public class AnalyseTagsDriver {
    @ApiOperation(value = "获取单元测试的结果,返回单元测试结果，例如：{result:['[]','['A','B']'],right:[true,true]}", response = Map.class)
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
                return AnalyseTagsUnitTest.UT_TC_001_002_Equiv();
            case "statement":
                return AnalyseTagsUnitTest.UT_TC_001_002_Statement();
            default:
                return AnalyseTagsUnitTest.UT_TC_001_002_Path();
        }
    }

    @ApiOperation(value = "输入学生编号测试analyseTags方法", response = String.class)
    @ApiImplicitParam(value = "学生编号", name = "sid", paramType = "query",dataType = "int")
    @GetMapping("/singleTest")
    @ResponseBody
    public String singleTest(@RequestParam(value = "sid", defaultValue = "1") int sid) {
        return AnalyseTagsService.analyseTags(sid).toString();
    }
}
