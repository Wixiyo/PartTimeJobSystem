package com.example.service;

import com.example.Interest.InterestService;
import com.example.jobmanager.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class AnalyseTagsService {

    /**
     * 引入兼职收藏Service
     */
    private final InterestService interestService;
    /**
     * 引入兼职标签解析Service
     */
    private final JobTagService jobTagService;
    /**
     * MAX_TAGS_NUMBER表示从所有标签中选取频次最高的5个
     */
    private static final int MAX_TAGS_NUMBER = 5;

    @Autowired
    public AnalyseTagsService(InterestService interestService, JobTagService jobTagService) {
        this.interestService = interestService;
        this.jobTagService = jobTagService;
    }

    /**
     * 分析学生的兼职兴趣
     *
     * @param sid 学生ID
     * @return 学生最感兴趣的5个标签
     */
    public List<Job> analyseTags(int sid) {
        List<Job> interestedJobs = interestService.getStuInterest(sid);
        List<String> top5Tags = new ArrayList<>();
        Map<String, Long> map = interestedJobs.stream()
                .map(job -> (job.getTags() != null && !job.getTags().equals("")) ? job.getTags().split(";") : null)
                .filter(Objects::nonNull).flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        if (map.keySet().size() <= MAX_TAGS_NUMBER) {
            top5Tags.addAll(map.keySet());
        } else {
            List<Map.Entry<String, Long>> infoIds = new ArrayList<>(map.entrySet());
            infoIds.sort((o1, o2) -> ((int) (o2.getValue() - o1.getValue())));
            for (int i = 0; i < MAX_TAGS_NUMBER; i++) {
                top5Tags.add(infoIds.get(i).getKey());
            }
        }
        return jobTagService.searchByTags(top5Tags);
    }
}
