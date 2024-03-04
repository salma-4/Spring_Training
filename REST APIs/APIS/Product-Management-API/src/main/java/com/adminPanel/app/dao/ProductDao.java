package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;
public interface ProductDao {
    public Product insert(ProductDetails productDetails);

    public Product findByID(int id);

    Product findByProductDetails(ProductDetails productDetails);

    public List< Product> findByName(String name);

    public void update(ProductDetails productDetails);


    public Product deleteByID(int id);

    public List<Product> getAllProducts();


}
