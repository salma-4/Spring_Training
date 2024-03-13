package com.app.boot;

import com.app.boot.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
   @Autowired
   Config config;


    @Value("${myApp.description.fullDescription}")
    private String full_desc;
    @GetMapping("/test1")
    public String test(){
        return full_desc;
    }
    @GetMapping("/test2")
    public String test2(){
        return config.getDescription().getFullDescription();
    }
}
