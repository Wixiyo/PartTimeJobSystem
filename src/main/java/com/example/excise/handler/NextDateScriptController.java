package com.example.excise.handler;

import com.example.excise.solution.NextDate;
import com.example.excise.test.NextDateTest;
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
 * @date 2021年06月16日9:03
 */
@Api(value = "万年历（计算下一天日期）的测试接口")
@Controller
public class NextDateScriptController {
    @ApiOperation(value = "执行万年历（计算下一天日期）的测试脚本，返回数据{result:result},异常情况下result为'测试异常'",response = Map.class)
    @ApiImplicitParam(value = "上传的文件",name = "file")
    @PostMapping(value = "/nextDateCases")
    @ResponseBody
    public Map<String,String> nextDateCases(MultipartFile file){
        Map<String,String>res=new HashMap<>();
        res.put("result", NextDateTest.test(file));
        return res;
    }
    @ApiOperation(value="输入万年历（计算下一天日期）的测试用例测试,返回测试结果",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "年份",name = "y",dataType = "int",paramType = "query"),
            @ApiImplicitParam(value = "月份",name = "m",dataType = "int",paramType = "query"),
            @ApiImplicitParam(value = "日",name = "d",dataType = "int",paramType = "query")
    })
    @GetMapping("/nextDateCase")
    @ResponseBody
    public String nextDateCase(
            @RequestParam(value = "y",defaultValue = "2020")int y,
            @RequestParam(value = "m",defaultValue = "1")int m,
            @RequestParam(value = "d",defaultValue = "1")int d){
        return NextDate.calculate(y, m, d);
    }
}
