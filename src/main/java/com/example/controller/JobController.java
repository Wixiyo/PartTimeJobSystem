package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.Job;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import com.example.service.JobService;
import com.example.service.JobTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@RestController
@RequestMapping("/job")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class JobController {

    @Autowired
    private JobService jobService;
    @Autowired
    private JobTagService jobTagService;

    @RequestMapping("/")//查询所有兼职
    public ResponseData getAllJob(){
//        return JSON.toJSONString(jobService.searchAll());//将查询结果对象转化成JSON格式输出
        return new ResponseData(ExceptionMsg.SUCCESS, jobService.searchAll());
    }

    @RequestMapping("/search/{title}")//按名称查询兼职
    public ResponseData getJobByTitle(@PathVariable String title){
//        return JSON.toJSONString(jobService.searchByTitle(title));//将查询结果对象转化成JSON格式输出
        return new ResponseData(ExceptionMsg.SUCCESS, jobService.searchByTitle(title));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)//新增兼职
    public ResponseData addJob(Job job){
        jobService.addJob(job);
        return new ResponseData(ExceptionMsg.SUCCESS,job);
    }

    @RequestMapping(value = "/delete/{busid}")//删除兼职
    public ResponseData deleteJob(@PathVariable String busid){
        jobService.deleteJob(busid);
        return new ResponseData(ExceptionMsg.SUCCESS,"已删除");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)//修改兼职信息
    public ResponseData updateJob(Job job){
        jobService.updateJob(job);
        return new ResponseData(ExceptionMsg.SUCCESS,job);
    }

    @RequestMapping(value = "/get-jobs-sorted-by-tags", method = RequestMethod.POST)
    public ResponseData getJobsSortedByTags(HttpServletRequest request) {
        String Tags = request.getParameter("tags");
        List<String> splitedTags = new ArrayList<>(Arrays.asList(Tags.split(";")));
        return new ResponseData(ExceptionMsg.SUCCESS, jobTagService.searchByTags(splitedTags));
    }

    @PostMapping("/uploadExcel")
    public ResponseData uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename(); // 获取文件名

        InputStream is = null;

        try{
            is = file.getInputStream();
            List<Map> jobList = jobService.getListByExcel(is,fileName);// 获取解析后的List集合
//            return new ResponseData(ExceptionMsg.SUCCESS, jobList);
             //System.out.println(studentList.toString());
            Boolean result = jobService.batchImportJobInfo(jobList); // 把数据插入数据库
            if (result){
                return new ResponseData(ExceptionMsg.SUCCESS, "文件上传成功");
            }else {
                return new ResponseData(ExceptionMsg.SUCCESS, "文件上传失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            is.close();
        }
        return new ResponseData(ExceptionMsg.FAILED, "文件错误");
    }
}
