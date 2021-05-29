package com.example.community;

import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
@Api(tags="社区交流接口")
public class PostController {
    @Autowired
    PostService postService;

    @ApiOperation(value = "用户发表帖子")
    @PostMapping(value = "/add")
    public ResponseData addPost(Post post) {
        postService.addPost(post);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }

    @ApiOperation(value = "对帖子评论")
    @PostMapping(value = "/add-post-comment")
    public ResponseData addPostComment(Comment comment) {
        postService.addComment(comment);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }

    @ApiOperation(value = "对兼职评论")
    @PostMapping(value = "/add-job-comment")
    public ResponseData addJobComment(JobComment jobComment) {
        postService.addJobComment(jobComment);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }

    @ApiOperation(value = "获取所有帖子")
    @GetMapping(value = "/get")
    public ResponseData getPosts(){
        return new ResponseData(ExceptionMsg.SUCCESS, postService.getPosts());
    }

    @ApiOperation(value = "获取某个帖子的评论")
    @GetMapping(value = "/get-comment/{pid}")
    public ResponseData getComments(@PathVariable Integer pid){
        return new ResponseData(ExceptionMsg.SUCCESS, postService.getComments(pid));
    }
    @ApiOperation(value = "获取某个兼职的评论")
    @GetMapping(value = "/get-job-comment/{busid}")
    public ResponseData getJobComments(@PathVariable String busid){
        return new ResponseData(ExceptionMsg.SUCCESS, postService.getJobComments(busid));
    }
}
