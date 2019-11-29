package com.baizhi.service;

import com.baizhi.entity.Comment;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CommentService {
    public List<Comment> add(String comment, HttpServletRequest request);
}
