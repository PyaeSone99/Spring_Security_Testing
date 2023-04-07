package com.example.csrfdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

 //curl -XPOST http://localhost:8080/hello -H 'Cookie: JSESSIONID=5C8BDA64971D2BAF347D080F79CB5A0A' -H 'X-CSRF-TOKEN tokeniQvKGg0nPqE9wn0h1KJvRCj-V9MXJjtSXY9Ddq8TKMeyJIDsvD36fjQWDZYQ9kgS5I9bJhrPerF0Flh_bu5zRMogG_CBEbPU'


    @PostMapping("/hello")
    public String postHello(){
        return "Post Hello!";
    }
}
