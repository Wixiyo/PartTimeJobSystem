package com.example.StudentManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    public boolean isUser(String openid) {
        return studentMapper.getStudentWithOpenId(openid) != null;
    }

    public Student getInfo(String openid) {
        return studentMapper.getStudentWithOpenId(openid);
    }

    public void addStudent(Student student) {
        studentMapper.addStudent(student);
        return;
    }

    public void updateStudent(Student student) {
        if(isUser(student.getOpenid())) {
            studentMapper.updateStudent(student);
        }
        return;
    }
}
