package com.baizhi.controller;

import com.baizhi.entity.Comment;
import com.baizhi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/add")
    public List<Comment> add(String comment, HttpServletRequest request) {
        List<Comment> add = commentService.add(comment, request);
        return add;
    }
}
