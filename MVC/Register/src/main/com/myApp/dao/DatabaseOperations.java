package main.com.myApp.dao;
import java.sql.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Setter
@Getter
// open connection with DB
public class DatabaseOperations {
    @Value("${database.url}")

    private String url;

    @Value("${database.password}")
    private String password;

    @Value("${database.username}")
    private String username;
    Connection connection =null;

    @PostConstruct
    public void connectToDb(){
     try{
         Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection(url,username,password);
         System.out.println("Connection established");

     } catch (SQLException | ClassNotFoundException e) {
         throw new RuntimeException(e);
     }
    }
    @PreDestroy
    public void destroyConnection(){
        try {
            connection.close();
            System.out.println("connection closed ................");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
