package com.example.recommendjob;

import com.example.jobmanager.Job;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
public interface IAnalyseTags {
    List<Job> analyseTags(int sid);
}
