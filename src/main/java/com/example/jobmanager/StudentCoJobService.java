package com.example.jobmanager;

import com.example.StudentManage.StudentMapper;
import com.example.community.Message;
import com.example.community.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StudentCoJobService {
    /**
     * APPLY表示学生报名被接受
     */
    private static final int APPLY = 1;
    /**
     * FINISH表示学生报名的兼职已结束
     */
    private static final int FINISH = 2;
    /**
     * REJECT表示学生报名被拒绝
     */
    private static final int REJECT = 3;
    /**
     * 引入学生报名兼职数据库Mapper
     */
    @Resource
    private StudentCoJobMapper studentcojobMapper;
    /**
     * 引入消息发送数据库Mapper
     */
    @Resource
    private MessageMapper messageMapper;
    /**
     * 引入学生管理数据库Mapper
     */
    @Resource
    private StudentMapper studentMapper;

    /**
     * 新增报名情况
     *
     * @param studentCoJob 报名详情
     */
    public void addStuCoJob(Studentcojob studentCoJob) {
        studentcojobMapper.add(studentCoJob);
    }

    /**
     * 更新学生报名情况，并向学生发送消息
     *
     * @param studentCoJob 学生报名情况
     */
    public void updateStuCoJob(Studentcojob studentCoJob) {
        if (studentCoJob != null && studentMapper.getStudentWithSId(studentCoJob.getSid()) != null) {
            studentcojobMapper.update(studentCoJob);
            Message message = new Message();
            message.setFrom("管理员");
            message.setState(0);
            if (studentCoJob.getState() == APPLY) {
                message.setText("您报名的兼职" + studentCoJob.getBusid() + "已通过报名");
            } else if (studentCoJob.getState() == FINISH) {
                message.setText("您参与的兼职" + studentCoJob.getBusid() + "已结束");
            } else if (studentCoJob.getState() == REJECT) {
                message.setText("您报名的兼职" + studentCoJob.getBusid() + "已被拒");
            } else {
                log.error("报名状态异常");
                return;
            }
            message.setTo(studentCoJob.getSid());
            messageMapper.insertMessage(message);
        } else {
            log.error("学生信息异常");
        }

    }

    /**
     * 查看学生是否报名
     *
     * @param busId 兼职ID
     * @param sid   学生ID
     * @return 学生报名详情
     */
    public Studentcojob isStuInApply(String busId, Integer sid) {
        return studentcojobMapper.isStuInApply(busId, sid);
    }

    /**
     * 查看兼职报名的人数
     *
     * @param busId 兼职ID
     * @return 兼职报名的人数
     */
    public Integer numsOfApply(String busId) {
        return studentcojobMapper.numsOfApply(busId);
    }

    /**
     * 根据兼职查找报名的学生
     *
     * @param sid   学生ID
     * @param state 报名状态
     * @return 报名兼职的学生列表
     */
    public List<Job> searchJobsOfStudent(int sid, int state) {
        return studentcojobMapper.searchJobsOfStudent(sid, state);
    }

    /**
     * 根据学生查找报名的兼职
     *
     * @param busId 兼职ID
     * @return 学生报名的兼职列表
     */
    public List<Map<String, Object>> searchStudentsOfJob(String busId) {
        return studentcojobMapper.searchStudentsOfJob(busId);
    }
}
