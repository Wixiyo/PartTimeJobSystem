package com.example.StudentManage;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentMapper {
    public Student getStudentWithOpenId(String openid);

    void addStudent(Student student);

    void updateStudent(Student student);
}
