package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${greeting.message}")
    private String message;

    @Value("${profil.message}")
    private String profilMessage;

    @GetMapping("/")
    public String hello() {
        return "Hello World!<br>" + message;
    }

    @GetMapping("/profil")
    public String getProfilMessage() {
        return profilMessage;
    }
}

