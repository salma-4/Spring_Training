package main.com.myApp.controller;

import main.com.myApp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Component
public class RegisterController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/")
    public String start(UserModel user, Model model){
        model.addAttribute("userModel",new UserModel());
        return "registerForm";
    }
    @RequestMapping("/formProcessing")
    public String showData(@Valid @ModelAttribute("userModel")UserModel userModel, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
            return "form";
        userDao.insert(userModel);
        model.addAttribute("userModel",userModel);

        return "showData";
    }
    @InitBinder
    private void removeWhiteSpaces(WebDataBinder dataBinder)
    {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class , trimmerEditor);
    }}