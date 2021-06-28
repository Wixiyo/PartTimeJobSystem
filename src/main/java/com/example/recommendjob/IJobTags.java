package com.example.recommendjob;

import com.example.jobmanager.Job;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
public interface IJobTags {
    List<Job> searchByTags(List<String> tags);
}
