package com.app.controller;

import com.app.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/showLoginPage")
    public String showLoginPage(Model model) {
        //model.addAttribute("loginForm", new LoginForm());
        return "loginPage";
    }
}
