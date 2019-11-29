package com.baizhi.service;

import com.baizhi.dao.CommentDao;
import com.baizhi.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> add(String comment, HttpServletRequest request) {
        Comment comment1 = new Comment();
        comment1.setId(UUID.randomUUID().toString());
        //User user = (User) request.getSession().getAttribute("user");
        String name = "xxx";
        comment1.setName(name);
        comment1.setComment(comment);
        comment1.setTime(new Date());

        commentDao.insert(comment1);
        List<Comment> comments = commentDao.selectAll();
        return comments;
    }
}
