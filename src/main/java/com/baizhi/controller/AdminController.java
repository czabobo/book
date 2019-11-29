package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request) {
        Admin admin = adminService.login(name, password);
        if (admin != null) {
            request.getSession().setAttribute("admin", admin);
            return "Booktable";
        }
        return null;
    }
}
