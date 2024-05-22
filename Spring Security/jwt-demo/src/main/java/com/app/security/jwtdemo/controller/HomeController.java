package com.app.security.jwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {
    @GetMapping("/hello")
    public String home(Principal principal){
        return "hello".concat(principal.getName());
    }
}
