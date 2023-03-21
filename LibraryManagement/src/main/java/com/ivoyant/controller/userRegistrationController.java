package com.ivoyant.controller;

import com.ivoyant.Service.UserService;
import com.ivoyant.dto.UserRegistrationDto;
import com.ivoyant.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class userRegistrationController {
    private UserService userService;

    public userRegistrationController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }
    @GetMapping
    public String showSignUp(){
        return"SignUp";
    }
    @PostMapping
    public String addUser(@ModelAttribute("user")UserRegistrationDto userRegistrationDto){
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
 }

