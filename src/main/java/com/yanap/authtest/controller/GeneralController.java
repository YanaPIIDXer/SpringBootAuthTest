package com.yanap.authtest.controller;

import com.yanap.authtest.request.UserRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
    @RequestMapping("/general")
    public String index() {
        return "general/index";
    }

    @RequestMapping("/general/login")
    public String login(Model model) {
        model.addAttribute("request", new UserRequest());
        return "general/login";
    }
}
