package com.example.jobManager;

import com.example.jobManager.Job;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface JobMapper {
    List<Job> searchAll();

    List<Job> searchByTitle(String title);

    void addJob(Job job);

    void deleteJob(String busid);

    void updateJob(Job job);

    // 批量导入学生信息
    Integer batchImportJobInfo(List<Map> jobList);

    Job searchById(String busid);
}
