package com.baizhi.controller;

import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request) {
        List<Book> books = bookService.selectAll();
        request.setAttribute("books", books);
        return "main";
        //return books;
    }

    @RequestMapping("/selectByPage")
    @ResponseBody
    public Map<String, Object> selectByPage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        /*
         * 总页数 total
         * 总条数 records
         * 当前页 page
         * 数据集合: rows = deps
         * */
        List<Book> books = bookService.selectByPage(page, rows);
        Integer counts = bookService.selectCount();
        Integer total = counts % rows == 0 ? counts / rows : counts / rows + 1;

        map.put("rows", books);
        map.put("total", total);
        map.put("page", page);
        map.put("records", counts);
        return map;

    }

    @RequestMapping("edit")
    @ResponseBody
    public void edit(String oper, Book book) {
        if (oper.equals("add")) {
            bookService.insert(book);
        } else if (oper.equals("edit")) {
            bookService.update(book);
        } else if (oper.equals("del")) {
            bookService.delete(book);
        }

    }

}
