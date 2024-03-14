package org.example.userservice.controller;

import org.example.userservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/userById")
    public User getUser(@RequestParam("id") int id){
        User user = new User(1,"salma");
        if(id == user.getId()){
            return user;
        }else
           return  new User(-1,"there is no user with this id");

    }

}
