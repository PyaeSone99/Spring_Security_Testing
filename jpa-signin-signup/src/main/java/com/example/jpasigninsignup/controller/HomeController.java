package com.example.jpasigninsignup.controller;

import com.example.jpasigninsignup.entity.User;
import com.example.jpasigninsignup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping({"/","/home"})
    public String home(){
        return "home";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/register")
    public String register(User user, BindingResult result){
        if (result.hasErrors()){
            return "signup";
        }
        System.out.println(user);
        userService.signUp(user);
        return "redirect:/login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }


    @GetMapping("/products")
    public String listProduct(Model model){
        List<String> fruits = List.of("Apple","Mango","Banana");
        model.addAttribute("fruits",fruits);
        return "products";
    }
}
