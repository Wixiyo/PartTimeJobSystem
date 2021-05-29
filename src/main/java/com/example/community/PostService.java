package com.example.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    public void addPost(Post post){
        postMapper.addPost(post);
    }

    public List<Post> getPosts() {
        return postMapper.getPost();
    }

    public void addComment(Comment comment) {
        postMapper.addComment(comment);
    }

    public List<Comment> getComments(Integer pid) {
        return postMapper.getComments(pid);
    }

    public void addJobComment(JobComment jobComment) {
        postMapper.addJobComment(jobComment);
    }
    public List<JobComment> getJobComments(String busid) {
        return postMapper.getJobComments(busid);
    }
}
