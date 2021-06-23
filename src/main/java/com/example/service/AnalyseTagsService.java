package com.example.service;

import com.example.Interest.InterestService;
import com.example.jobManager.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalyseTagsService {

    @Autowired
    InterestService interestService;

    @Autowired
    JobTagService jobTagService;

    public List<Job> analyseTags(int sid) {
        List<Job> interestedJobs = interestService.getStuInterest(sid);
        List<String> top5Tags = new ArrayList<>();
        Map<String, Long> map = interestedJobs.stream().map(job -> (job.getTags() != null && !job.getTags().equals("")) ? job.getTags().split(";") : null)
                .filter(Objects::nonNull).flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        if (map.keySet().size() <= 5) top5Tags.addAll(map.keySet());
        else {
            List<Map.Entry<String, Long>> infoIds = new ArrayList<>(map.entrySet());
            infoIds.sort((o1, o2) -> ((int)(o2.getValue() - o1.getValue())));
            top5Tags.add(infoIds.get(0).getKey());
            top5Tags.add(infoIds.get(1).getKey());
            top5Tags.add(infoIds.get(2).getKey());
            top5Tags.add(infoIds.get(3).getKey());
            top5Tags.add(infoIds.get(4).getKey());
        }
        return jobTagService.searchByTags(top5Tags);
    }
}
