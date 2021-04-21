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
     * 获取帖子
     * @param page 页码
     * @return 8个帖子数据
     */
    ArrayList<Post> getPosts(int page);
}
