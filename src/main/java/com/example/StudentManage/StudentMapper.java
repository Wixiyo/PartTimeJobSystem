package com.example.StudentManage;

import java.util.Collection;
import java.util.List;

public interface StudentMapper {
    public Student getStudentWithOpenId(String openid);

    void addStudent(Student student);

    void updateStudent(Student student);
}
