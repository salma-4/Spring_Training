package com.adminPanel.app.dao;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class Dao implements  ProductDao{
  @Autowired
    SessionFactory sessionFactory;

    @Override
    public Product insert(ProductDetails productDetails) {
        try {
            Session session = sessionFactory.getCurrentSession();
            // Check if the ProductDetails already exists in the database
            ProductDetails existingProductDetails = session.get(ProductDetails.class, productDetails.getId());
            if (existingProductDetails == null) {
                // If not exists, persist the ProductDetails first
                session.persist(productDetails);
            } else {
                // If exists, update the existing ProductDetails with the new data
                existingProductDetails.setName(productDetails.getName());
                // Update other fields as needed
                session.update(existingProductDetails);
            }
            // Create a new Product entity and set the ProductDetails
            Product product = new Product();
            product.setName(productDetails.getName());
            product.setProductDetails(productDetails);
            // Persist the Product entity
            session.persist(product);
            return product;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public Product findByID(int id) {
        try{
         Session session = sessionFactory.getCurrentSession();
         Product product =session.get(Product.class,id);
         return product;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findByProductDetails(ProductDetails productDetails) {
        try{
            Session session = sessionFactory.getCurrentSession();
            ProductDetails pd = session.get(ProductDetails.class,productDetails.getId());
            return pd.getProduct();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        try{
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from Product where name=:productName");
             query.setParameter("productName",name);
              return query.list();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(ProductDetails newProduct) {
        try{
           Session session = sessionFactory.getCurrentSession();

           ProductDetails oldProductDetails = session.get(ProductDetails.class,newProduct.getId());
           Product oldProduct = oldProductDetails.getProduct();

            oldProduct.setName(newProduct.getName());
            oldProductDetails.setName(newProduct.getName());
            oldProductDetails.setExpirationDate(newProduct.getExpirationDate());
            oldProductDetails.setManufacturer(newProduct.getManufacturer());
            oldProductDetails.setPrice(newProduct.getPrice());
            oldProductDetails.setAvailable(newProduct.isAvailable());
            oldProductDetails.setProduct(newProduct.getProduct());

            oldProduct.setProductDetails(oldProductDetails); // here is a question ??????????

            session.update(oldProduct);


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Product deleteByID(int id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            Product product = session.get(Product.class,id);
            session.delete(product);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        try{
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from Product");
            return (List<Product>) query.list();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
