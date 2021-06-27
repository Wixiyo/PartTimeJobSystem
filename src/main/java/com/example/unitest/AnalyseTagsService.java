package com.example.unitest;

import com.example.jobmanager.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author panxiangyu
 * 2021年06月24日0:16
 * AnalyseTags函数所属的方法
 */
final class AnalyseTagsService {
    private AnalyseTagsService() {
    }
    /**
     * MAX_TAGS_NUMBER表示从所有标签中选取频次最高的5个
     */
    private static final int MAX_TAGS_NUMBER = 5;
    public static List<String> analyseTags(int sid) {
        List<Job> interestedJobs = AnalyseTagsStub.getStuInterest(sid);
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
        return top5Tags;
    }
}
