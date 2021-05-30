package com.example.Interest;

import com.example.jobManager.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestMapper {

    List<Job> getStuInterest(int sid);
    void addInterest(Interest interest);
}
