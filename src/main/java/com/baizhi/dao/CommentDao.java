package com.baizhi.dao;

import com.baizhi.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDao {
    @Insert("insert into comment values(#{id},#{name},#{comment},#{time})")
    public void insert(Comment comment);

    @Select("select * from comment")
    public List<Comment> selectAll();
}
