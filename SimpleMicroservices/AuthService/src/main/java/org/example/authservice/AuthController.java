package org.example.authservice;

import org.example.authservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthController {

    @GetMapping("/authUser")
    public String authUser(@RequestParam("id")int id){
        RestTemplate restTemplate= new RestTemplate();
        String url ="http://localhost:8080/userById?id="+id;
        User user= restTemplate.getForObject(url,User.class);
        if(user.getId()!=-1)
            return "authenticated";
        else
            return "access denied";


    }
}
