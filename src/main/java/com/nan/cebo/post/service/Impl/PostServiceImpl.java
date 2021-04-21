package com.nan.cebo.post.service.Impl;

import com.nan.cebo.post.domain.Post;
import com.nan.cebo.post.persistence.PostMapper;
import com.nan.cebo.post.service.PostService;
import com.nan.cebo.utils.competition.apply.TeamIdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostServiceImpl implements PostService {

    public static int PAGE_NUM = 8;

    @Autowired
    private PostMapper postMapper;

    @Override
    public String insertPost(Post post) {
        String postId = TeamIdGenerate.generateId() + "p";
        post.setId(postId);
        post.setRead_count(0);
        try {
            postMapper.insertPost(post);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return "success";
    }

    @Override
    public ArrayList<Post> getPosts(int page) {
        return postMapper.getPosts(page * PAGE_NUM);
    }
}
