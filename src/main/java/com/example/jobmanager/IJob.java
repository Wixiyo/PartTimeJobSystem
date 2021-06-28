package com.example.jobmanager;

import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
public interface IJob {
    List<Job> searchAll();
}
