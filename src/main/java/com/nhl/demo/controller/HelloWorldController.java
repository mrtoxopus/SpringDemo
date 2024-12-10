package com.nhl.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    
    private final String defaultGreeting;
    
    public HelloWorldController(@Value("${greeting.default}") String defaultGreeting) {
        this.defaultGreeting = defaultGreeting;
    }
    
    @GetMapping("/hello")
    public String helloWorld() {
        return defaultGreeting;
    }
    
    @GetMapping("/bye")
    public String byeWorld() {
        return "Bye World!";
    }
}
