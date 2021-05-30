package com.example.Interest;

import com.example.jobManager.Job;
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
