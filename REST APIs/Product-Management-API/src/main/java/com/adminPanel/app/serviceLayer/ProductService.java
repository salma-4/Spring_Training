package com.adminPanel.app.serviceLayer;

import com.adminPanel.app.exception.ProductNotFoundException;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;


public interface ProductService
{
    ProductDetails insert(ProductDetails product);
    Product findById(int id) throws ProductNotFoundException;
    void deleteById(int id) throws ProductNotFoundException;
    ProductDetails update(ProductDetails product);
    List<Product> getAllProducts();

    List<Product> findByName(String searchKey) throws ProductNotFoundException;
}
