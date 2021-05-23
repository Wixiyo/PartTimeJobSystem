package com.example.service;

import com.example.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalyseTagsService {

    @Autowired
    InterestService interestService;

    @Autowired JobTagService jobTagService;

    public List<Job> AnalyseTags(int sid) {
        List<Job> interestedJobs = interestService.getStuInterest(sid);
        List<String> top5Tags = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Boolean> visited = new HashMap<String, Boolean>();

        for(Job curJob : interestedJobs) {
            if(curJob.getTags() != null) {
                List<String> splitedTags = new ArrayList<>(Arrays.asList(curJob.getTags().split(";")));
                for(String tag : splitedTags) {
                    int count = map.containsKey(tag) ? map.get(tag) : 0;
                    visited.put(tag, false);
                    map.put(tag, count + 1);
                }
            }
        }

        if(map.size() <= 5) {
            for(String curTag : map.keySet()) {
                top5Tags.add(curTag);
            }
        } else {
            for(int i = 0; i < 5; i++) {
                int max = -0x7fffffff;
                String maxTag = new String();
                for(String curTag : map.keySet()) {
                    if(!visited.get(curTag)) {
                        if(map.get(curTag) > max) {
                            max = map.get(curTag);
                            maxTag = curTag;
                        }
                    }
                }
                top5Tags.add(maxTag);
                visited.put(maxTag, true);
            }
        }
        return jobTagService.searchByTags(top5Tags);
    }
}
