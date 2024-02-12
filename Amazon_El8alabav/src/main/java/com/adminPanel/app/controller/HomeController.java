package com.adminPanel.app.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
public class HomeController
{

    @RequestMapping("/")
    public String homePage()
    {
        return "homePage";
    }
    @GetMapping("/addProduct")
    public String showAddProductForm() {//Model model
        //model.addAttribute("product", new Product()); // Create a new product object
        return "addProducts";
    }

    @PostMapping("/addProduct")
    public String addProduct() {//@Valid Product product, BindingResult bindingResult
//        if (bindingResult.hasErrors()) {
//            return "addProducts"; // Return to form with errors
//        }
//        productService.saveProduct(product); // Save the product
        return "redirect:/"; // Redirect to home page after successful addition
    }
}
