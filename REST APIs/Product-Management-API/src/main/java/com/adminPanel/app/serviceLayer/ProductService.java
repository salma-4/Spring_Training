package com.adminPanel.app.serviceLayer;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;


public interface ProductService
{
    ProductDetails insert(ProductDetails product);
    Product findById(int id);
    void deleteById(int id);
    ProductDetails update(ProductDetails product);
    List<Product> getAllProducts();

    List<Product> findByName(String searchKey);
}
