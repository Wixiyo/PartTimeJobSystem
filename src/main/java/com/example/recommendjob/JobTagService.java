package com.example.recommendjob;

import com.example.jobmanager.Job;
import com.example.jobmanager.JobMapper;
import com.example.jobmanager.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class JobTagService implements IJobTags{
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
                if(getJobScore(job1, tags) == getJobScore(job2, tags)) return 0;
                return getJobScore(job1, tags) > getJobScore(job2, tags) ? -1 : 1;
            }
        });
        return allJobs;
    }
}