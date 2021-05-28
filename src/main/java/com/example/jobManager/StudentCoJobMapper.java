package com.example.jobManager;

import com.example.jobManager.Studentcojob;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCoJobMapper {

    void add(Studentcojob scjob);

    void update(Studentcojob scjob);

    Studentcojob isStuInApply(String busid,Integer sid);

    Integer numsOfApply(String busid);
}