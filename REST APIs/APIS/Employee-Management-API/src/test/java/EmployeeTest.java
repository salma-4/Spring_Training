import com.adminPanel.app.model.Employee;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;


public class EmployeeTest {
   RestTemplate restTemplate =new RestTemplate();
   @Test
   public void testFindById(){
     String url ="http://localhost:8080/Employee-Management-API/employees/employee?employeeId=3";
       ResponseEntity<Employee>  response=restTemplate.getForEntity(url,Employee.class);
       assertEquals(response.getStatusCode(), HttpStatus.OK);
       System.out.println("Passed");
   }

   @Test
    public void testInsertEmployee(){
       String url ="http://localhost:8080/Employee-Management-API/employees";
       Employee employee= new Employee("sara","It unit","sara@gmail.com","trainee",4000);
       Employee response=restTemplate.postForObject(url,employee,Employee.class);
       assertEquals(response.getName(),employee.getName());
       System.out.println("passed");
   }
   @Test
    public void testDeleteById(){
       String url="http://localhost:8080/Employee-Management-API/employees?employeeId=12";
          restTemplate.delete(url);
   }
   @Test
   public void testUpdate(){
       String url="http://localhost:8080/Employee-Management-API/employees";
       Employee employee= new Employee(6,"mona","Backend","salma4@gmail.com","junior",6000);
       restTemplate.put(url,employee,Employee.class);

   }
}