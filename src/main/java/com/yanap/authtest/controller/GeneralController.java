package com.yanap.authtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
    @RequestMapping("/admin")
    public String index() {
        return "general/index";
    }

    @RequestMapping("/general/login")
    public String login() {
        return "general/login";
    }
}
