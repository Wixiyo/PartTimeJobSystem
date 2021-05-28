package com.example.community;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {
    void addPost(Post post);
    List<Post> getPost();

    void addComment(Comment comment);

    List<Comment> getComments(Integer pid);
}
