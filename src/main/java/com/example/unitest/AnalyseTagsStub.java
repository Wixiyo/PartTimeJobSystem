package com.example.unitest;

import com.example.jobmanager.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panxiangyu
 * 2021年06月24日0:04
 * AnalyseTags的桩
 */
final class AnalyseTagsStub {
    private AnalyseTagsStub() {
    }
    /**
     *
     * @param sid 学生编号
     * @return java.util.List<com.example.jobmanager.Job> 所有收藏过的兼职
     */
    public static List<Job> getStuInterest(int sid) {
        if (sid <= 1) {
            return new ArrayList<>();
        } else if (sid == 2) {
            return new ArrayList<>();
        } else if (sid == 3) {
            List<Job>list = new ArrayList<>();
            Job job = new Job();
            job.setTags("A,B");
            list.add(job);
            return list;
        } else {
            List<Job>list = new ArrayList<>();
            Job job = new Job();
            job.setTags("A,B");
            list.add(job);
            job.setTags("A,B,C,D,E");
            list.add(job);
            return list;
        }
    }
}
