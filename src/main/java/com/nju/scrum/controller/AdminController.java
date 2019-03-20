package com.nju.scrum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/unCredit.html")
    public String unCredit(Model model) {
        String name = "jiangbei";
        model.addAttribute("name", name);
        return "unCredit";
    }
}
