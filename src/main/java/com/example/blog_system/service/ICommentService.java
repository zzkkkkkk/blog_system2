package com.example.blog_system.service;

import com.github.pagehelper.PageInfo;
import com.example.blog_system.model.domain.Comment ;

public interface ICommentService {
    // 获取文章下的评论 10.4.2
    public PageInfo<Comment> getComments(Integer aid, int page, int count);
    // §10.4.3 用户发布评论
    public void pushComment(Comment comment);
}