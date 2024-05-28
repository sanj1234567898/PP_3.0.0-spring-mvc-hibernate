package com.project.controllers;

import com.project.models.User;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping()
    public String usersPage(Model model) {
        //get all users from BD
        List<User> list = userService.getAllUsers();

        //add the list of user to model
        model.addAttribute("users", list);

        return "user/users";
    }

    @GetMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        return "user/create-user";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        //save new user
        if (user.getId() == null) {
            userService.saveUser(user);
        } else {
            userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @PostMapping("/edit")
    @GetMapping("/edit")
    public String create (@RequestParam("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/create-user";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return "redirect:/users";
    }
}
