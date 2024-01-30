package vechicleSystem.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vechicleSystem.models.Vehicle;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

@Component
@Scope("singelton")
public class DataBaseOperations {
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")

    private String userName;
    @Value("${database.password}")

    private String password;
    private Connection con=null;
@PostConstruct
    public void connectToDataBase() {
   try{

         con=DriverManager.getConnection(
               url,userName,password);

       System.out.println("Connection established.............");


   }catch(Exception e){
       System.out.println(e);
    }

}

  public Vehicle save (Vehicle vehicle){
    //jdbc code to store in db
    return vehicle;
  }
    private void disconnectFromDatabase() {
       try {
            con.close();
            System.out.println("Disconnecting from the database.............");

     } catch ( SQLException e) {
            throw new RuntimeException(e);
      }

   }
}
