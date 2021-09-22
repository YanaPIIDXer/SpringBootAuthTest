package com.yanap.authtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
    @RequestMapping("/general")
    public String index() {
        return "general/index";
    }

    @RequestMapping("/login/general/auth")
    public String login() {
        return "general/login";
    }
}
