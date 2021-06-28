package com.example.jobmanager;

import com.example.Interest.InterestMapper;
import com.example.student.StudentMapper;
import com.example.utils.ExcelUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class JobService implements IJob{
    /**
     * NO_APPLY表示学生没有报名兼职
     */
    private static final int NO_APPLY = -1;
    /**
     * ERROR_CODE是错误码
     */
    private static final int ERROR_CODE = 500;
    /**
     * 引入兼职管理数据库操作层
     */
    @Resource
    private JobMapper jobMapper;
    /**
     * 引入报名管理数据库操作层
     */
    @Resource
    private StudentCoJobMapper studentCoJobMapper;
    /**
     * 引入收藏管理数据库操作层
     */
    @Resource
    private InterestMapper interestMapper;
    /**
     * 引入学生管理数据库操作层
     */
    @Resource
    private StudentMapper studentMapper;

    /**
     * 查询使用兼职
     *
     * @return 兼职列表
     */
    public List<Job> searchAll() {
        return jobMapper.searchAll();
    }

    /**
     * 按标题查询兼职
     *
     * @param title 兼职标题
     * @return 兼职详情
     */
    public List<Job> searchByTitle(String title) {
        return jobMapper.searchByTitle(title);
    }

    /**
     * 新增兼职
     *
     * @param job 兼职实体类
     */
    public void addJob(Job job) {
        jobMapper.addJob(job);
    }

    /**
     * 删除兼职
     *
     * @param busId 兼职ID
     */
    public void deleteJob(String busId) {
        jobMapper.deleteJob(busId);
    }

    /**
     * 更新兼职
     *
     * @param job 兼职实体类
     */
    public void updateJob(Job job) {
        jobMapper.updateJob(job);
    }

    /**
     * 从excel表格中获取兼职列表
     *
     * @param is       excel输入流
     * @param fileName excel文件名
     * @return 兼职列表
     */
    public List<Map<String, String>> getListByExcel(InputStream is, String fileName) {

        try {
            return new ArrayList<>(ExcelUtil.AnalysisExcel(is, fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * 批量上传兼职
     *
     * @param list 兼职集合Map
     * @return 布尔值表示是否成功
     */
    public Boolean batchImportJobInfo(List<Map<String, String>> list) {
        Integer flag = jobMapper.batchImportJobInfo(list);
        return flag > 0;
    }

    /**
     * 按兼职编号查询兼职
     *
     * @param busId 兼职编号
     * @return 兼职实体类
     */
    public Job searchById(String busId) {
        return jobMapper.searchById(busId);
    }

    /**
     * 查询兼职对学生的详细信息
     *
     * @param busId 兼职编号
     * @param sid   学生id
     * @return map 兼职详情
     */
    public Map<String, Integer> jobForStu(String busId, Integer sid) {
        Map<String, Integer> map = new HashMap<>();
        if (jobMapper.searchById(busId) != null && studentMapper.getStudentWithSId(sid) != null) {
            map.put("numsOfApply", studentCoJobMapper.numsOfApply(busId));
            if (studentCoJobMapper.isStuInApply(busId, sid) != null) {
                map.put("isApply", studentCoJobMapper.isStuInApply(busId, sid).getState());
            } else {
                map.put("isApply", NO_APPLY);
            }
            if (interestMapper.isStuInterest(busId, sid) != null) {
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
