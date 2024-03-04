package com.adminPanel.app.controller;

import com.adminPanel.app.exception.EmptyDataException;
import com.adminPanel.app.exception.ProductNotFoundException;
import com.adminPanel.app.exception.response.ProductErrorResponse;
import com.adminPanel.app.model.AnotherApiData;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.serviceLayer.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    public ProductDetails insertProduct(@RequestBody ProductDetails productDetails) throws EmptyDataException {

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


        Product product = productService.findById(id);
        ProductDetails pd = product.getProductDetails();
            return pd;
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
        return productService.findById(id);
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
    productService.deleteById(id);
   return  "deleted";
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
      return productService.findByName(searchKey);
    }

    //way to microservices ):
    @GetMapping("/callingAnother")
 public String callingAnotherApi(){
     String url ="https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate = new RestTemplate();
        AnotherApiData data=restTemplate.getForObject(url,AnotherApiData.class);
        return data.getBody();
     }

    @GetMapping("/callingAnotherApi")
    public ResponseEntity<String> callingAnotherApi1() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response;
    }
    //==> we can use all http  methods

}
