package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/secured")
    public String secured(){
        return "secured";
    }
}
