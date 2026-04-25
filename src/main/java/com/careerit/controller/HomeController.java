package com.careerit.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

    @Cacheable("message")
    @GetMapping("/")
    public String home() {
        System.out.println("Calling API...");
        return "Spring Boot CI/CD Success";
    }
}
