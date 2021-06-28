package com.example.student;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    Student getStudentWithOpenId(String openid);

    Student getStudentWithSId(Integer sid);

    void addStudent(Student student);

    void updateStudent(Student student);
}
