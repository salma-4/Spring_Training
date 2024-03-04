package com.adminPanel.app.serviceLayer;

import com.adminPanel.app.dao.ProductDao;
import com.adminPanel.app.exception.EmptyDataException;
import com.adminPanel.app.exception.ProductNotFoundException;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductDao productDAO;


    public ProductDetails insert(ProductDetails productDetails) throws EmptyDataException{
        if(!productDetails.getName().isEmpty()) {
            productDAO.insert(productDetails);
            return productDetails;
        }
        else
            throw new EmptyDataException("the data entered is invalid may be you forget to enter  an item ");
    }


    public Product findById(int id) throws ProductNotFoundException {
        if(id<=0 || id>1000)
            throw new ProductNotFoundException("this id is invalid");
        else {
            Product product = productDAO.findByID(id);
            if(product==null)
                throw new ProductNotFoundException("there is no product in this id"+id);
            else
                return product;
        }
    }

    public void deleteById(int id)throws ProductNotFoundException {
        if(id<=0 || id>1000)
            throw new ProductNotFoundException("this id is invalid");
        else {
            Product product = productDAO.findByID(id);
            if(product==null)
                throw new ProductNotFoundException("there is no product in this id"+id);
            else
                productDAO.deleteByID(id);
        }
    }


    public ProductDetails update(ProductDetails productDetails) {
        //search for the related product if exist or not
        Product product = productDAO.findByProductDetails(productDetails);
        if (product != null) {
            productDAO.update(productDetails);
        } else
            throw new NullPointerException();
        return productDetails;
    }


    @Transactional
    public List<Product> getAllProducts() {
        try {
            return productDAO.getAllProducts();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Transactional
    public List<Product> findByName(String searchKey) throws ProductNotFoundException {
        if(searchKey=="")
            throw new ProductNotFoundException("where is the product name!");
        else{
            List<Product> productList= productDAO.findByName(searchKey);
            if(productList.isEmpty())
                throw new ProductNotFoundException("there is no product in this name");
            else
                return productList;
        }
    }
}
