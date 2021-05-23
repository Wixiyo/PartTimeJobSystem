package com.example.service;

import com.example.entity.Post;
import com.example.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;
    public List<Post> searchAll(){
        return postMapper.searchAll();
    }

    public List<Post> searchByTitle(String title) {
        return postMapper.searchByTitle(title);
    }

    public void addpost(Post post) {
        postMapper.addPost(post);
    }

    public void deletepost(int jid) {
        postMapper.deletePost(jid);
    }

    public void updatepost(Post post) {
        postMapper.updatePost(post);
    }
}
