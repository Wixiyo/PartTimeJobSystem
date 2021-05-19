package com.example.service;

import com.example.entity.Interest;
import com.example.entity.Job;
import com.example.mapper.InterestMapper;
import com.example.mapper.JobMapper;
import com.example.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestService {
    @Autowired
    InterestMapper interestMapper;

    public List<Job> getStuInterest(int sid) {
         return interestMapper.getStuInterest(sid);
    }
    public void addInterest(Interest interest){
        interestMapper.addInterest(interest);
    }
}
