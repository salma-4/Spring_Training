package main.com.myApp.controller;


import main.com.myApp.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.soap.SOAPBinding;

@Controller
@Component

public class FormController {
    @RequestMapping("/")
    public String showFormPage (Model model){
        model.addAttribute("user",new UserModel());
        return "form";
    }
    @RequestMapping("/formProcessing")
    public String showData(@ModelAttribute("user")UserModel userModel ,Model model)
    {
        model.addAttribute("userModel",userModel);
        return "showData";
    }
}
