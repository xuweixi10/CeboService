package com.nan.cebo.post.persistence;

import com.nan.cebo.post.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PostMapper {

    /**
     * 发表帖子
     * @param post 帖子信息
     */
    void insertPost(Post post);

    /**
     * 获取制定帖子id的详细信息
     * @param postId 帖子id
     * @return 帖子详细信息
     */
    Post getPost(String postId);
    /**
     * 获取帖子
     * @param page 页码
     * @return 8个帖子数据
     */
    ArrayList<Post> getPosts(int page);

    /**
     * 获取用户发布的帖子
     * @param userId 用户id
     * @return 所有帖子
     */
    ArrayList<Post> getUserPosts(String userId);
}
