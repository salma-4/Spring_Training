package com.adminPanel.app.controller;

import com.adminPanel.app.exception.ProductNotFoundException;
import com.adminPanel.app.exception.response.ProductErrorResponse;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.serviceLayer.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@Api(tags = "Api to handle products")
public class ProductsController
{

    @Autowired
    private ProductService productService;
@GetMapping("/")
@ApiIgnore
public String  show(){
    return "200 ok :)";
}

    @PostMapping("/products")
    @ApiOperation(value ="Add new product ")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "ok , inserted "),
            @ApiResponse(code=201,message = "the product is created"),
            @ApiResponse(code= 505 ,message = "there is a problem from server side"),
    })
    public ProductDetails insertProduct(@RequestBody ProductDetails productDetails){

       return productService.insert(productDetails);

    }

    @PutMapping("/products")
    @ApiOperation(value="update  an existing product")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "ok , updated "),
            @ApiResponse(code=201,message = "the product is updated"),
            @ApiResponse(code=404 , message = "not found ,there is no product matches"),
            @ApiResponse(code= 505 ,message = "there is a problem from server side"),
    })
    public ProductDetails updateProduct(@RequestBody ProductDetails productDetails){
        return  productService.update(productDetails);
    }


    @GetMapping("/products/productDetailsById")
    @ApiOperation(value = "show product details by id")
    @ApiParam(name = "id",required = true,value = "id of product")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "ok , the product details are here "),
            @ApiResponse(code=404 , message = "not found ,there is no product in this id"),
            @ApiResponse(code= 505 ,message = "there is a problem from server side")
    })
    public ProductDetails getProductDetailsById(@RequestParam int id) throws ProductNotFoundException{
    if(id<=0|| id>1000)
        throw new ProductNotFoundException("invlaid id");
    else {

        Product product = productService.findById(id);
        if(product==null)
            throw new ProductNotFoundException("there is no product int his id");
         else {
            ProductDetails pd = product.getProductDetails();
            return pd;
        }
    }
    }
    @GetMapping("/products/productById")
    @ApiOperation(value = "search for product by id")
    @ApiParam(name = "id",required = true,value = "id of product")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "ok , the product is here "),
            @ApiResponse(code=404 , message = "not found ,there is no product in this id"),
            @ApiResponse(code= 505 ,message = "there is a problem from server side")
    })
    public Product  getProductById(@RequestParam int id)throws ProductNotFoundException {
        if(id<=0 || id>1000)
            throw new ProductNotFoundException("this id is invalid");
        else {
            Product product = productService.findById(id);
            if(product==null)
                throw new ProductNotFoundException("there is no product in this id"+id);
            else
              return product;
        }
    }


    @DeleteMapping("/products")
    @ApiOperation(value = "delete product by id ")
    @ApiParam(name = "id",required = true,value = "id of product")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "deletion done "),
            @ApiResponse(code=404 , message = "not found ,there is no product in this id"),
            @ApiResponse(code= 505 ,message = "there is a problem from server side")
    })
    public String deleteById(@RequestParam int id)throws ProductNotFoundException{
        if(id<=0 || id>1000)
            throw new ProductNotFoundException("this id is invalid");
        else {
            Product product = productService.findById(id);
            if(product==null)
                throw new ProductNotFoundException("there is no product in this id"+id);
            else
                return "deleted";
        }

    }
    @GetMapping("/products/allProducts")
    @ApiOperation(value = "show all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "ok ,all products are for you "),
            @ApiResponse(code=404 , message = "not found ,empty"),
            @ApiResponse(code= 505 ,message = "there is a problem from server side")
    })
    public List<Product> gatAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/productDetailsByName")
    @ApiOperation(value="search for product by name ")
    @ApiParam(name = "searchKey",required = true,value = "name of product")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "ok ,there is the details "),
            @ApiResponse(code=404 , message = "not found ,there is no product in this name"),
            @ApiResponse(code= 505 ,message = "there is a problem from server side")
    })
    public List<Product> getProductDetailsByName(@RequestParam String searchKey)throws ProductNotFoundException{
      if(searchKey=="")
          throw new ProductNotFoundException("where is the product name!");
      else{
          List<Product> productList= productService.findByName(searchKey);
                  if(productList.isEmpty())
                      throw new ProductNotFoundException("there is no product in this name");
                  else
                   return productList;
      }
    }

@ExceptionHandler
    public ProductErrorResponse handlerForProductNotFound(ProductNotFoundException exception){
      ProductErrorResponse errorResponse = new ProductErrorResponse();
      errorResponse.setCode(HttpStatus.NOT_FOUND.value());
      errorResponse.setMessage(exception.getMessage());
      errorResponse.setTimeStamp(System.currentTimeMillis());
      return  errorResponse;
}
}
