package com.project.java.controller;

import com.project.java.entity.UserRegister;
import com.project.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserRegister());
        return "registration";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserRegister user){
        userService.registerUser(user);
        return "redirect:/product/get";
    }
}
