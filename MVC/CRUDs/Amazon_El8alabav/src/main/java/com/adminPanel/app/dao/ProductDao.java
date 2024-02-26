package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductDao {
public Product insertIntoDB(ProductDetails productDetails);
public Product findById(int id);
    Product findByProductDetails(ProductDetails productDetails);
    void deleteById(int id);
    void update(ProductDetails product);
    List<Product> getAllProducts();

    List<Product> findByName(String searchKey);


}
