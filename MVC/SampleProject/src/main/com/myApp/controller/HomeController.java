package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.*;
import sun.misc.Contended;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String showHomePage() {

        return "homePage";
    }

    @RequestMapping("/showPage")
    public String showPage(HttpServletRequest request, Model model) {
        String studentName = request.getParameter("studentName");
        model.addAttribute("studentName", studentName);
        return "showPage";
    }
}