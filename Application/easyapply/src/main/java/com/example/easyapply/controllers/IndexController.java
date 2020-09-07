package com.example.easyapply.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("message", "Hello everyone, we are go to back to Spring with together");
        model.addAttribute("date", new Date());

        return "index";
    }
}
