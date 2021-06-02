package com.example.jobManager;

import com.example.jobManager.Studentcojob;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentCoJobMapper {

    void add(Studentcojob scjob);

    void update(Studentcojob scjob);

    Studentcojob isStuInApply(String busid,Integer sid);

    Integer numsOfApply(String busid);

    List<Job> searchJobsOfStudent(int sid, int state);

    List<Map<String, Object>> searchStudentsOfJob(String busid);
}