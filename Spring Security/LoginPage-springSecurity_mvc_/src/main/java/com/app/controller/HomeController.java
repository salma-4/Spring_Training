package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome()
    {
        return "home";
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage()
    {
        return "loginPage";
    }

    @GetMapping("/systems")
    public String showSystemPage()
    {
        return "systemParentPage";
    }

    @GetMapping("/systems/systemChild")
    public String showSystemChildPage()
    {
        return "systemPageChild";
    }

    @GetMapping("/accessDenied")
    public String showAccessDeniedPage()
    {
        return "accessDenied";
    }
}




