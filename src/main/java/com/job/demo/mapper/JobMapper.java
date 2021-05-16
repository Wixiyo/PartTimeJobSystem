package com.job.demo.mapper;

import com.job.demo.entity.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobMapper {
    List<Job> searchAll();

    List<Job> searchByTitle(String title);

    void addJob(Job job);

    void deleteJob(int jid);

    void updateJob(Job job);
}
