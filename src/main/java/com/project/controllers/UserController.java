package com.project.controllers;

import com.project.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @GetMapping("/")
    public String getAllUser () {
        return "index";
    }
}
