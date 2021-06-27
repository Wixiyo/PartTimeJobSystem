package com.example.excise.handler;

import com.example.excise.solution.TriangleType;
import com.example.excise.test.TriangleTypeTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panxiangyu
 * @date 2021年06月16日9:14
 */
@Api(value = "三角形类型的测试接口")
@Controller
public class TriangleTypeScriptController {
    @ApiOperation(value = "执行三角形的测试脚本，返回数据{result:result},异常情况下result为'测试异常'", response = Map.class)
    @ApiImplicitParam(value = "上传的文件",name = "file")
    @PostMapping(value = "/triangleTypeCases")
    @ResponseBody
    public Map<String, String> triangleTypeCases(MultipartFile file) {
        Map<String, String> res = new HashMap<>();
        res.put("result", TriangleTypeTest.test(file));
        return res;
    }
    @ApiOperation(value="输入三角形的测试用例测试,返回测试结果{result:'直角三角形'}",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "a边",name = "a",dataType = "double",paramType = "query"),
            @ApiImplicitParam(value = "b边",name = "b",dataType = "double",paramType = "query"),
            @ApiImplicitParam(value = "c边",name = "c",dataType = "double",paramType = "query")
    })
    @GetMapping("/triangleTypeCase")
    @ResponseBody
    public Map<String, String> triangleTypeCase(
            @RequestParam(value = "a",defaultValue = "1")double a,
            @RequestParam(value = "b",defaultValue = "1")double b,
            @RequestParam(value = "c",defaultValue = "1")double c){
        Map<String, String> res = new HashMap<>();
        res.put("result", TriangleType.determineType(a, b, c));
        return res;
    }
}
