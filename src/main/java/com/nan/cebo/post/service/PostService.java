package com.nan.cebo.post.service;

import com.nan.cebo.post.domain.Post;

import java.awt.*;
import java.util.ArrayList;

public interface PostService {
    /**
     * 发表帖子
     * @param post 帖子信息
     * @return 帖子标识
     */
    String insertPost(Post post);

    Post getPost(String postId);

    ArrayList<Post> getPosts(int page);

    ArrayList<Post> getUserPosts(String userId);
}
