package com.example.jobManager;

import com.example.entity.BaseJob;
import com.example.jobManager.Job;
import com.example.jobManager.JobMapper;
import com.example.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class JobService {
    @Autowired
    JobMapper jobMapper;
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

}
