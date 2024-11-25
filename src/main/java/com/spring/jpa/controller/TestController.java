package com.spring.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class TestController {

    @GetMapping
    public String welcome() {
        return "Welcome to Spring Data JPA";
    }
}
