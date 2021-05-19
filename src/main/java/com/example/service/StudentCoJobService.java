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

    public int UpdateEmpList(int id){
        return studentcojobMapper.changeStatus(id,1);
    }

    public List<HashMap<String,Object>> selectEmpList(int jid){
        return studentcojobMapper.selectEmpList(jid);
    }

    public List<Job> selectBusinessJobList(int bid){
        return  studentcojobMapper.selectBusinessJobList(bid);
    }

    public List<Job> selectStudentJobList(int sid){
        return studentcojobMapper.selectStudentJobList(sid);
    }


    public void addStuCoJob(Studentcojob scjob) {
        studentcojobMapper.add(scjob);
    }

    public void updateStuCoJob(Studentcojob scjob) {
        studentcojobMapper.update(scjob);
    }
}
