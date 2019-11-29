package com.baizhi.service;

import com.baizhi.aspect.Log;
import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    @Log(name = "添加业务")
    public void insert(Book book) {
        book.setId(UUID.randomUUID().toString());
        book.setImage("1.jpg");
        book.setTime(new Date());
        bookDao.insert(book);
    }

    @Override
    @Log(name = "修改业务")
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    @Log(name = "删除业务")
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Book selectById(String id) {
        return bookDao.selectById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Book> selectByPage(Integer page, Integer count) {
        Integer start = (page - 1) * count;
        return bookDao.selectByPage(start, count);
    }

    @Override
    public Integer selectCount() {
        return bookDao.selectCount();
    }
}
