package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request) {
        User user = userService.login(name, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "redirect:/book/selectAll";
        }
        return null;
    }
}
