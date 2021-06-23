package com.example.jobManager;

import com.example.Interest.InterestMapper;
import com.example.entity.BaseJob;
import com.example.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class JobService {
    @Autowired
    JobMapper jobMapper;
    @Autowired
    StudentCoJobMapper studentCoJobMapper;
    @Autowired
    InterestMapper interestMapper;

    public List<Job> searchAll(){

        return jobMapper.searchAll();
    }

    public List<Job> searchByTitle(String title) {
        return jobMapper.searchByTitle(title);
    }

    public void addJob(Job job) {
        jobMapper.addJob(job);
    }

    public void deleteJob(String busid) {
        jobMapper.deleteJob(busid);
    }

    public void updateJob(Job job) {
        jobMapper.updateJob(job);
    }

    public List<Map> getListByExcel(InputStream is, String fileName) throws IOException {

        try{
            List<Map> studentList = new ExcelUtil(new BaseJob()).AnalysisExcel(is, fileName);
            return studentList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public Boolean batchImportJobInfo(List<Map> list){
        Integer flag = jobMapper.batchImportJobInfo(list);
        if (flag > 0){
            return true;
        } else return false;
    }

    public Job searchById(String busid) {
        return jobMapper.searchById(busid);
    }

    /**
     * 查询兼职对学生的详细信息
     * @param busid 兼职编号
     * @param sid 学生id
     * @return map 兼职详情
     */
    public Map<String, Integer> jobForStu(String busid,Integer sid){
        Map<String, Integer> map = new HashMap<>();
        map.put("numsofapply",studentCoJobMapper.numsOfApply(busid));
        if(studentCoJobMapper.isStuInApply(busid,sid)!=null){
            map.put("isApply",studentCoJobMapper.isStuInApply(busid,sid).getState());
        }
        else {
            map.put("isApply",-1);
        }
        if(interestMapper.isStuInterest(busid,sid)!=null){
            map.put("isInterest",1);
        }
        else {
            map.put("isInterest",0);
        }
        return map;
    }
}
