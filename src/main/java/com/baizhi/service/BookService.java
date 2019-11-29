package com.baizhi.service;

import com.baizhi.aspect.Log;
import com.baizhi.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> selectAll();

    @Log(name = "添加业务")
    public void insert(Book book);

    @Log(name = "修改业务")
    public void update(Book book);

    @Log(name = "删除业务")
    public void delete(Book book);

    public Book selectById(String id);

    public List<Book> selectByPage(Integer page, Integer count);

    public Integer selectCount();
}
