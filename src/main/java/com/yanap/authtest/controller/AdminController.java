package com.yanap.authtest.controller;

import com.yanap.authtest.request.UserRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/admin")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/admin/login")
    public String login(Model model) {
        model.addAttribute("request", new UserRequest());
        return "admin/login";
    }
}
