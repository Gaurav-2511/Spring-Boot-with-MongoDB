package com.gaurav.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelthCheck {

    @GetMapping("/helth-check")
    public String helthCheck() {
        return "OK";
    }
}

