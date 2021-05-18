package com.job.demo.service;

import com.job.demo.entity.Job;
import com.job.demo.mapper.StudentcojobMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentcojobService {
    @Resource
    private StudentcojobMapper studentcojobMapper;

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


}
