package com.adminPanel.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

//    @Autowired
//    private ProductService productService; // Inject your product service

    @GetMapping("/")
    public String homePage() {//Model model
        //<Product> products = productService.getAllProducts(); // Get all products
        //model.addAttribute("products", products);
        return "homePage";
    }

    @GetMapping("/addProduct/new") // Use GET for displaying form
    public String showAddProductForm() {//Model model
       // model.addAttribute("product", new Product()); // Create empty product object
        return "addProducts";
    }

    @PostMapping("/addProduct") // Use POST for form submission
    public String addProduct() {///@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes
//        if (bindingResult.hasErrors()) {
//            return "addProducts"; // Return to form with errors
//        }
//        productService.saveProduct(product); // Save the product
//        redirectAttributes.addFlashAttribute("successMessage", "Product added successfully!"); // Add success message
//        return "redirect:/"; // Redirect to home page with success message
        return "addProducts";


    }
}
