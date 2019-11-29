package com.baizhi.dao;

import com.baizhi.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from book")
    public List<Book> selectAll();

    @Insert("insert into book values(#{id},#{name},#{author},#{image},#{content},#{time})")
    public void insert(Book book);

    @Update("update book set name=#{name},author=#{author},image=#{image},content=#{content},time=#{time} where id=#{id}")
    public void update(Book book);

    @Delete("delete from book where id=#{id}")
    public void delete(Book book);

    @Select("select * from book where id=#{id}")
    public Book selectById(String id);

    //分页
    @Select("select * from book limit #{start},#{count}")
    public List<Book> selectByPage(Integer start, Integer count);

    @Select("select count(id) from book")
    public Integer selectCount();
}
