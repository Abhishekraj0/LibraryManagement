package com.ivoyant.controller;

import com.ivoyant.Repo.UserRepo;
import com.ivoyant.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

        @GetMapping("/login")
        public String login() {
            return "login";
        }
        @GetMapping("/")
    public String home(){return "Main";}


}
