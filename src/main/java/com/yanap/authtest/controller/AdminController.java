package com.yanap.authtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/admin")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/login/admin/auth")
    public String login() {
        return "admin/login";
    }
}
