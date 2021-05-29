package com.example.jobManager;

import com.example.jobManager.Studentcojob;
import com.example.jobManager.StudentCoJobMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public Studentcojob isStuInApply(String busid,Integer sid){
        return studentcojobMapper.isStuInApply(busid,sid);
    }

    public Integer numsOfApply(String busid){
        if(studentcojobMapper.numsOfApply(busid)==null)
            return 0;
        else
            return studentcojobMapper.numsOfApply(busid);
    }

    public List<Job> searchJobsOfStudent(int sid, int state) {
        return studentcojobMapper.searchJobsOfStudent(sid, state);
    }
}
