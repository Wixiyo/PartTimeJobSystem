package com.example.jobmanager;

import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import com.example.service.JobTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "兼职管理接口")
public class JobController {

    @Autowired
    private JobService jobService;
    @Autowired
    private StudentCoJobService studentCoJobService;
    @Autowired
    private JobTagService jobTagService;

    /**
     * 查询所有兼职
     * @return
     */
    @ApiOperation(value = "查询所有兼职", notes = "查询所有兼职")
    @GetMapping("/")
    public ResponseData getAllJob(){
//        return JSON.toJSONString(jobService.searchAll());//将查询结果对象转化成JSON格式输出
        return new ResponseData(ExceptionMsg.SUCCESS, jobService.searchAll());
    }

    @ApiOperation(value = "查询用户兼职报名情况", notes = "查询某兼职对某用户的细节信息")
    @GetMapping("/details")//查询所有兼职
    public ResponseData getAllJobDetails(@RequestParam("sid") Integer sid,@RequestParam("busid") String busid){
        Map map = new HashMap<>();
        map.put("isapply",studentCoJobService.isStuInApply(busid,sid));
        map.put("numsofapply",studentCoJobService.numsOfApply(busid));
        return new ResponseData(ExceptionMsg.SUCCESS, map);
    }


    @ApiOperation(value = "按名称查询兼职", notes = "按名称查询兼职")
    @GetMapping("/search/{title}")//按名称查询兼职
    public ResponseData getJobByTitle(@PathVariable String title){
        return new ResponseData(ExceptionMsg.SUCCESS, jobService.searchByTitle(title));
    }

    @ApiOperation(value = "按编号查询兼职", notes = "按编号查询兼职")
    @GetMapping("/getdetial/{busid}")//按名称查询兼职
    public ResponseData getJobById(@PathVariable String busid){
        return new ResponseData(ExceptionMsg.SUCCESS, jobService.searchById(busid));
    }

    @ApiOperation(value = "查询学生对兼职的报名及收藏情况", notes = "查询学生对兼职的报名及收藏情况")
    @GetMapping("/job-for-stu/{busid}/{sid}")//按名称查询兼职
    public ResponseData jobForStu(@PathVariable String busid,@PathVariable Integer sid){
        return new ResponseData(ExceptionMsg.SUCCESS, jobService.jobForStu(busid,sid));
    }

    /**
     * 新增兼职
     * @param job
     * @return
     */
    @ApiOperation(value = "新增兼职")
    @PostMapping(value = "/add")
    public ResponseData addJob(Job job){
        jobService.addJob(job);
        return new ResponseData(ExceptionMsg.SUCCESS,job);
    }

    /**
     * 删除兼职
     * @param busid
     * @return
     */
    @ApiOperation(value = "删除兼职")
    @GetMapping(value = "/delete/{busid}")
    public ResponseData deleteJob(@PathVariable String busid){
        jobService.deleteJob(busid);
        return new ResponseData(ExceptionMsg.SUCCESS,"已删除");
    }

    /**
     * 修改兼职信息
     * @param job
     * @return
     */
    @ApiOperation(value = "修改兼职信息")
    @PostMapping(value = "/update")
    public ResponseData updateJob(Job job){
        jobService.updateJob(job);
        return new ResponseData(ExceptionMsg.SUCCESS,job);
    }

    @ApiOperation(value = "根据兼职标签排序")
    @PostMapping(value = "/get-jobs-sorted-by-tags")
    public ResponseData getJobsSortedByTags(HttpServletRequest request) {
        String Tags = request.getParameter("tags");
        List<String> splitedTags = new ArrayList<>(Arrays.asList(Tags.split(";")));
        return new ResponseData(ExceptionMsg.SUCCESS, jobTagService.searchByTags(splitedTags));
    }

    @ApiOperation(value = "根据excel表导入兼职")
    @PostMapping("/uploadExcel")
    public ResponseData uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename(); // 获取文件名

        InputStream is = null;

        try{
            is = file.getInputStream();
            List<Map<String,String>> jobList = jobService.getListByExcel(is,fileName);// 获取解析后的List集合
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
