package com.github.yas411.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DemoRestController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
