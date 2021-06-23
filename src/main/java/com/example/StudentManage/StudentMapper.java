package com.example.StudentManage;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentMapper {
    Student getStudentWithOpenId(String openid);

    Student getStudentWithSId(Integer sid);

    void addStudent(Student student);

    void updateStudent(Student student);
}
