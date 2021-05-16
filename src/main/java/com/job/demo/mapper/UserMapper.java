package com.job.demo.mapper;

import com.job.demo.entity.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Job Sel(int id);
}
