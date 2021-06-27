package com.example.unitest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panxiangyu
 * 2021年06月23日20:21
 * 被测试的方法所属的类
 */
final class JobService {
    private JobService() {
    }
    /**
     * NO_APPLY表示学生没有报名兼职
     */
    private static final int NO_APPLY = -1;
    /**
     * ERROR_CODE是错误码
     */
    private static final int ERROR_CODE = 500;
    public static Map<String, Integer> jobForStu(String busId, Integer sid) {
        Map<String, Integer> map = new HashMap<>();
        if (JobForStuStub.searchById(busId) != null && JobForStuStub.getStudentWithSId(sid) != null) {
            map.put("numsOfApply", JobForStuStub.numsOfApply(busId));
            if (JobForStuStub.isStuInApply(busId, sid) != null) {
                map.put("isApply", JobForStuStub.isStuInApply(busId, sid));
            } else {
                map.put("isApply", NO_APPLY);
            }
            if (JobForStuStub.isStuInterest(busId, sid) != null) {
                map.put("isInterest", 1);
            } else {
                map.put("isInterest", 0);
            }
        } else {
            map.put("code", ERROR_CODE);
        }
        return map;
    }
}
