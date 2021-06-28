package com.example.integrationtest;

import com.example.recommendjob.IAnalyseTags;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/analyseTagsIntegration")
@Api(value = "集成测试对AnalyseTags接口测试")
public class AnalyseTagsIntegrationDriver {
    /**
     * 一个系统中可用的用户ID是10006
     */
    private static final int SID = 10006;

    /**
     * 一个系统中不存在的用户ID是0
     */
    private static final int SID_NULL = 0;

    /**
     * 一个系统错误用户ID是-1
     */
    private static final int SID_ERROR = -1;

    /**
     * 注入被测对象AnalyseTagsService
     */
    @Resource
    private IAnalyseTags analyseTagsService;

    /**
     * @return 测试结果
     */
    @ApiOperation(value = "集成测试对AnalyseTags接口测试", response = String.class)
    @GetMapping("/analyseTagsTest")
    @ResponseBody
    public Map<Object, Object> insertMessageTest() {
        HashMap<Object, Object> result = new HashMap<>();
        List<String> testResult = new ArrayList<>();

        /*测试IT＿TD＿002_001*/
        if (analyseTagsService.analyseTags(SID_ERROR).isEmpty()) {
            testResult.add("没有返回预期结果");
        } else {
            testResult.add("成功返回预期结果");
        }

        /*测试IT＿TD＿002_002*/
        if (analyseTagsService.analyseTags(SID_NULL).isEmpty()) {
            testResult.add("成功返回预期结果");
        } else {
            testResult.add("没有返回预期结果");
        }

        /*测试IT＿TD＿002_003*/
        if (analyseTagsService.analyseTags(SID).isEmpty()) {
            testResult.add("成功返回预期结果");
        } else {
            testResult.add("没有返回预期结果");
        }

        result.put("result", testResult);
        return result;
    }
}
