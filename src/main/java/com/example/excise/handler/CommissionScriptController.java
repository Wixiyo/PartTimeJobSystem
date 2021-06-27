package com.example.excise.handler;

import com.example.excise.solution.Commission;
import com.example.excise.test.CommissionTest;
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
 * @date 2021年06月16日8:52
 */
@Api(value = "销售额的测试接口")
@Controller
public class CommissionScriptController {
    @ApiOperation(value = "执行销售额的测试脚本，返回数据{result:result},异常情况下result为'测试异常'", response = Map.class)
    @ApiImplicitParam(value = "上传的文件", name = "file")
    @PostMapping(value = "/commissionCases")
    @ResponseBody
    public Map<String, String> commissionCases(MultipartFile file) {
        Map<String, String> res = new HashMap<>();
        res.put("result", CommissionTest.test(file));
        return res;
    }

    @ApiOperation(value = "输入销售额的测试用例测试,返回测试结果", response = double.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "主机数量", name = "h", dataType = "int",paramType = "query"),
            @ApiImplicitParam(value = "显示器数量", name = "d", dataType = "int",paramType = "query"),
            @ApiImplicitParam(value = "外设数量", name = "p", dataType = "int",paramType = "query")
    })
    @GetMapping("/commissionCase")
    @ResponseBody
    public double commissionCase(
            @RequestParam(value = "h",defaultValue = "1") int h,
            @RequestParam(value = "d",defaultValue = "1")int d,
            @RequestParam(value = "p",defaultValue = "1")int p) {
        return Commission.calculate(h, d, p);
    }
}
