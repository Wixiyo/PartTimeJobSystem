package com.example.excise.handler;

import com.example.excise.solution.Bill;
import com.example.excise.test.BillTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panxiangyu
 * @date 2021年05月10日20:01
 */
@Controller
@Api(value = "电信收费的测试接口")
public class BillScriptController {
    @ApiOperation(
            value = "执行电信收费的测试脚本，返回数据{result:result},异常情况下result为'测试异常'",
            response = Map.class
    )
    @ApiImplicitParam(value = "上传的文件",name = "file")
    @PostMapping(value = "/billCases")
    @ResponseBody
    public Map<String,String> billCases(MultipartFile file){

        Map<String,String>res=new HashMap<>();
        res.put("result", BillTest.test(file));
        return res;
    }
    @ApiOperation(value = "输入电信收费的测试用例进行测试,返回执行结果",response = double.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "通话时间",name = "d",dataType = "int",paramType = "query"),
            @ApiImplicitParam(value = "本年度未缴费次数",name="f",dataType = "int",paramType = "query")
    })
    @GetMapping("/billCase")
    @ResponseBody
    public double billCase(
            @RequestParam(value = "d",defaultValue = "1") int d,
            @RequestParam(value = "f",defaultValue = "1") int f
    ){
        return Bill.calculate(d,f);
    }
}
