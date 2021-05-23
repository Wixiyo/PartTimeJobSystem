package com.example.controller;

import com.example.entity.Job;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import com.example.service.AnalyseTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/analyse-tags")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class AnalyseTagsController {

    @Autowired
    AnalyseTagsService analyseTagsService;

    @RequestMapping(value = "/{sid}", method = RequestMethod.GET)
    public ResponseData AnalyseTags(@PathVariable int sid) {
        List<Job> result = analyseTagsService.AnalyseTags(sid);
        return new ResponseData(ExceptionMsg.SUCCESS, result);
    }
}
