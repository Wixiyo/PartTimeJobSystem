package com.example.Interest;

import com.example.jobmanager.Job;
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
    public Interest isStuInterest(String busid,Integer sid){
        return interestMapper.isStuInterest(busid,sid);
    }

    public void deleteInterest(int sid, String busid) {
        interestMapper.deleteInterest(sid,busid);
    }
}
