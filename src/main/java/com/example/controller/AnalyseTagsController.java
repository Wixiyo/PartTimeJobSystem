package com.example.controller;

import com.example.jobManager.Job;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import com.example.service.AnalyseTagsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analyse-tags")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
@Api(tags = "兼职分析接口")
public class AnalyseTagsController {

    @Autowired
    AnalyseTagsService analyseTagsService;

    @ApiOperation(value = "分析兼职标签")
    @GetMapping(value = "/{sid}")
    public ResponseData AnalyseTags(@PathVariable int sid) {
        List<Job> result = analyseTagsService.AnalyseTags(sid);
        return new ResponseData(ExceptionMsg.SUCCESS, result);
    }
}
