package com.example.service;

import com.example.entity.Job;
import com.example.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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

    public void deleteJob(int jid) {
        jobMapper.deleteJob(jid);
    }

    public void updateJob(Job job) {
        jobMapper.updateJob(job);
    }
}
