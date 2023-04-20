package com.example.corsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class MainController {

    private Logger logger = Logger.getLogger(MainController.class.getName());


    @GetMapping("/")
    public String main(){
        return "main";
    }

    @PostMapping("/test")
    @ResponseBody
    public String test(){
        logger.info("test method called");
        return "hello";
    }

}
