package com.chessgg.chessapp.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController2 {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Looks for login.html in /resources/templates
    }
}
