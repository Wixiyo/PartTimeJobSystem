package com.example.integrationtest;

import com.example.jobmanager.JobService;
import com.example.recommendjob.IJobTags;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/searchByTagsIntegration")
@Api(value = "集成测试对searchByTags接口测试")
public class SearchByTagsIntegrationDriver {
    /**
     * 。
     * 注入被测对象JobTagService
     */
    @Resource
    private IJobTags jobTagService;

    /**
     * 。
     * 注入兼职管理接口
     */
    @Resource
    private JobService jobService;

    /**
     * @return 测试结果
     */
    @ApiOperation(value = "集成测试对searchByTags接口测试", response = String.class)
    @GetMapping("/searchByTags")
    @ResponseBody
    public Map<Object, Object> searchByTagsTest() {
        HashMap<Object, Object> result = new HashMap<>();
        List<String> testResult = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        /*测试IT＿TD＿003_001*/
        tags.add("");
        if (jobTagService.searchByTags(tags).retainAll(jobService.searchAll())) {
            testResult.add("符合预期结果");
        } else {
            testResult.add("不符合预期结果");
        }

        /*测试IT＿TD＿003_002*/
        tags.add("家教");
        tags.add("英语");
        String resultTags = jobTagService.searchByTags(tags).get(0).getTags();
        if (resultTags.contains("家教") || resultTags.contains("英语")) {
            testResult.add("符合预期结果");
        } else {
            testResult.add("不符合预期结果");
        }

        result.put("result", testResult);
        return result;
    }
}
