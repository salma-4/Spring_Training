package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.serviceLayer.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class HomeController
{

    @Autowired
    private ProductService productService;
@GetMapping("/")
public String  show(){
    return "200 ok :)";
}

    @PostMapping("/products")
    public ProductDetails insertProduct(@RequestBody ProductDetails productDetails){

       return productService.insert(productDetails);

    }

    @PutMapping("/products")
    public ProductDetails updateProduct(@RequestBody ProductDetails productDetails){
        return  productService.update(productDetails);
    }
    //TODO search

    @GetMapping("/products/productDetailsById")
    public ProductDetails getProductDetailsById(@RequestParam int id){
        Product product = productService.findById(id);
        ProductDetails pd =product.getProductDetails();
        return pd;
    }
    @GetMapping("/products/productById")
    public Product  getProductById(@RequestParam int id){

        Product product = productService.findById(id);
        return product;
    }


    @DeleteMapping("/products")
    public String deleteById(@RequestParam int id){
        productService.deleteById(id);
        return "deleted";

    }
    @GetMapping("/products/allProducts")
    public List<Product> gatAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/productDetailsByName")
    public List<Product> getProductDetailsByName(@RequestParam String searchKey){

    return productService.findByName(searchKey);
    }


}
