package com.example.unitest;

import com.example.jobmanager.Studentcojob;

/**
 * @author panxiangyu
 * 2021年06月23日22:33
 * UpdateStuCoJob方法所属类
 */
final class StudentCoJobService {
    private StudentCoJobService() {
    }
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
     *
     * @param studentCoJob 需要更新的学生信息
     * @return java.lang.String 返回更新结果
     */
    public static String updateStuCoJob(Studentcojob studentCoJob) {
        if (studentCoJob != null && UpdateStuCoJobStub.getStudentWithSId(studentCoJob.getSid()) != null) {
            if (studentCoJob.getState() == APPLY) {
                return "通过";
            } else if (studentCoJob.getState() == FINISH) {
                return "结束";
            } else if (studentCoJob.getState() == REJECT) {
                return "拒绝";
            } else {
               return "兼职状态异常";
            }
        } else {
            return "学生信息异常";
        }
    }
}
