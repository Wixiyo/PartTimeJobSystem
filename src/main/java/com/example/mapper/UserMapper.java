package com.example.mapper;

import com.example.entity.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Job Sel(int id);
}
