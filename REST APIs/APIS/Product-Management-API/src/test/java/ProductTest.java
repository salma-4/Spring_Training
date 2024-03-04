import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    RestTemplate restTemplate= new RestTemplate();
    @Test
    public void findById(){
        String url=  "http://localhost:8080/Product-Management-API/products/productById?id=2";
        ResponseEntity<Product> response= restTemplate.getForEntity(url, Product.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testInsertProduct() throws ParseException {
        SimpleDateFormat  simpleDateFormat= new SimpleDateFormat("YYYY-MM-DD");
        String url="http://localhost:8080/Product-Management-API/products";
        ProductDetails productDetails= new ProductDetails("Tea",simpleDateFormat.parse("2025-04-23"),"el3rousa",12.4,true);
        ProductDetails res= restTemplate.postForObject(url,productDetails,ProductDetails.class);
        assertEquals(productDetails.getName(),res.getName());
    }
     @Test
    public void  testDeleteById(){
        String  url  ="http://localhost:8080/Product-Management-API/products?id=5";
            restTemplate.delete(url);
         System.out.println("deleted sucessfully");
     }

     @Test
    public void testUpdate() throws ParseException {
         SimpleDateFormat  simpleDateFormat= new SimpleDateFormat("YYYY-MM-DD");
         String url="http://localhost:8080/Product-Management-API/products";
         ProductDetails productDetails= new ProductDetails(6,"Tea",simpleDateFormat.parse("2025-04-23"),"el3rousa",18,true);
            restTemplate.put(url,productDetails,ProductDetails.class);
         System.out.println("updated");

     }
}
