package com.example.jobManager;

import com.example.StudentManage.StudentMapper;
import com.example.community.Message;
import com.example.community.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class StudentCoJobService {
    @Resource
    private StudentCoJobMapper studentcojobMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    StudentMapper studentMapper;

    //新增报名情况
    public void addStuCoJob(Studentcojob scjob) {
        studentcojobMapper.add(scjob);
    }

    //更新学生报名情况，并向学生发送消息
    public void updateStuCoJob(Studentcojob scjob) {
        if(scjob!=null&&studentMapper.getStudentWithSId(scjob.getSid())!=null){
            studentcojobMapper.update(scjob);
            Message message = new Message();
            message.setFrom("管理员");
            message.setState(0);
            if(scjob.getState()==1){
                message.setText("您报名的兼职"+scjob.getBusid()+"已通过报名");
            }else if (scjob.getState()==2){
                message.setText("您参与的兼职"+scjob.getBusid()+"已结束");
            }else if (scjob.getState()==3){
                message.setText("您报名的兼职"+scjob.getBusid()+"已被拒");
            }else {
                log.error("报名状态异常");
                return;
            }
            message.setTo(scjob.getSid());
            messageMapper.insertMessage(message);
        }else {
            log.error("学生信息异常");
        }

    }

    //查看学生是否报名
    public Studentcojob isStuInApply(String busid,Integer sid){
        return studentcojobMapper.isStuInApply(busid,sid);
    }

    //查看兼职报名的人数
    public Integer numsOfApply(String busid){
        return studentcojobMapper.numsOfApply(busid);
    }

    //根据兼职查找报名的学生
    public List<Job> searchJobsOfStudent(int sid, int state) {
        return studentcojobMapper.searchJobsOfStudent(sid, state);
    }

    //根据学生查找报名的兼职
    public List<Map<String,Object>> searchStudentsOfJob(String busid) {
        return studentcojobMapper.searchStudentsOfJob(busid);
    }
}
