package com.example.mapper;

import com.example.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {
    List<Post> searchAll();

    List<Post> searchByTitle(String title);

    void addPost(Post post);

    void deletePost(int sid);

    void updatePost(Post post);
}
