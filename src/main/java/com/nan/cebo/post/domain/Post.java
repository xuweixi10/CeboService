package com.nan.cebo.post.domain;

import lombok.Data;

/**
 * 帖子基本数据
 */
@Data
public class Post {
    String id;
    String user_id;
    String title;
    String content;
    int read_count;

    public Post(){

    }
}
