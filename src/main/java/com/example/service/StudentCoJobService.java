package com.example.service;

import com.example.entity.Job;
import com.example.entity.Studentcojob;
import com.example.mapper.StudentCoJobMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentCoJobService {
    @Resource
    private StudentCoJobMapper studentcojobMapper;

    public void addStuCoJob(Studentcojob scjob) {
        studentcojobMapper.add(scjob);
    }

    public void updateStuCoJob(Studentcojob scjob) {
        studentcojobMapper.update(scjob);
    }
}
