package com.example.service;

import com.example.jobManager.Job;
import com.example.jobManager.JobMapper;
import com.example.jobManager.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class JobTagService {
    @Autowired
    JobMapper jobMapper;

    @Autowired
    JobService jobService;

    private int getJobScore(Job job, List<String> tags) {
        int ans = 0;
        for(String tag : tags) {
            if (job.getTags() != null && job.getTags().indexOf(tag) != -1) {
                ans++;
            }
        }
        return ans;
    }

    public List<Job> searchByTags(List<String> tags) {
        List<Job> allJobs = jobService.searchAll();
        Collections.sort(allJobs, new Comparator<Job>() {
            public int compare(Job job1, Job job2) {
                return getJobScore(job1, tags) > getJobScore(job2, tags) ? -1 : 1;
            }
        });
        return allJobs;
    }
}