package com.nan.cebo.post.controller;

import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.post.domain.Post;
import com.nan.cebo.post.service.PostService;
import com.nan.cebo.recruit.domain.pojos.RecruitInfo;
import com.nan.cebo.recruit.domain.vos.HotCompetitionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ResponseResult publish(@RequestBody Post post) {
        if (post.getUser_id() == null) {
            return ResponseResult.errorResult(3000, "account error");
        }
        String result = postService.insertPost(post);
        if (result.equals("success")) {
            return ResponseResult.okResult(null);
        } else {
            return ResponseResult.errorResult(3000, "unknown error");
        }
    }

    @RequestMapping(value = "/getPost", method = RequestMethod.GET)
    public ResponseResult getPosts(@RequestParam("page") int page) {
        return ResponseResult.okResult(postService.getPosts(page));
    }
}
