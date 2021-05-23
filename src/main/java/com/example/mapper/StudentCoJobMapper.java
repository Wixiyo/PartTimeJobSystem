package com.example.mapper;

import com.example.entity.Studentcojob;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCoJobMapper {

    void add(Studentcojob scjob);

    void update(Studentcojob scjob);
}