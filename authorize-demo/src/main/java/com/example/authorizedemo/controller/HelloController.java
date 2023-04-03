package com.example.authorizedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello pyae sone";
    }

    @GetMapping("/greeting")
    public String greeting(){
        return "Hi!How are you";
    }

    @GetMapping("/home")
    public String something(){
        return "sonething";
    }

    @PostMapping("/sayHello")
    public String sayHello(){
        return "say hello";
    }

    @GetMapping("/products/product/{code}")
    public String productCode(@PathVariable String code){
        return code;
    }
}
