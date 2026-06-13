package com.gaurav.controller;

import com.gaurav.entity.User;
import com.gaurav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;


    @GetMapping("/helth-check")
    public String helthCheck() {
        return "OK";
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}

