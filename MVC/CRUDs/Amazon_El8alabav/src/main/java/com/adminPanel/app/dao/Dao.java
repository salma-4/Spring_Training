package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Dao implements ProductDao{
    @Autowired
    public SessionFactory sessionFactory;
    @Override
    public Product insertIntoDB(ProductDetails productDetails) {
      try {
          Session session = sessionFactory.getCurrentSession();
          Product product = new Product(productDetails.getName());
          product.setProductDetails(productDetails);
          session.persist(product);
         return product;
      }catch (Exception  exception){
          exception.printStackTrace();
      }
      return null;
    }

    @Override
    public Product findById(int id) {

        try{
            Session session = sessionFactory.getCurrentSession();
            return session.get(Product.class, id);
           
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findByProductDetails(ProductDetails productDetails) {
        try{

            Session session = sessionFactory.getCurrentSession();
        ProductDetails productDetails1=  session.get(ProductDetails.class,productDetails.getId());
         return productDetails1.getProduct();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,id);
          session.delete(product);
    }

    @Override
    public void update(ProductDetails newProduct) {
        try {
            Session session = sessionFactory.getCurrentSession();

            //the old and new id will be the same but different data
            ProductDetails oldProductDetails = session.get(ProductDetails.class, newProduct.getId());
            Product oldProduct = oldProductDetails.getProduct();

            //set the values with new values
            oldProduct.setName(newProduct.getName());
            oldProductDetails.setName(newProduct.getName());
            oldProductDetails.setExpirationDate(newProduct.getExpirationDate());
            oldProductDetails.setManufacturer(newProduct.getManufacturer());
            oldProductDetails.setPrice(newProduct.getPrice());
            oldProductDetails.setAvailable(newProduct.getAvailable());
            oldProductDetails.setProduct(newProduct.getProduct());

            //we will set the oldProductDetails after update to the oldProduct and the oldProduct will be updated too
            oldProduct.setProductDetails(oldProductDetails);

            session.update(oldProduct);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        Session session =  sessionFactory.getCurrentSession();
        Query query =session.createQuery("From Product");
        return (List<Product>) query.list();
    }

    @Override
    public List<Product> findByName(String searchKey) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where name=:productName");
        query.setParameter("productName" , searchKey);
        return query.list();
    }
}
