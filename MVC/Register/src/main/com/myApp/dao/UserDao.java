package main.com.myApp.dao;

import main.com.myApp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class UserDao {
   private DatabaseOperations databaseOperations;
    @Autowired
    public UserDao(DatabaseOperations databaseOperations){
        this.databaseOperations=databaseOperations;
    }
    public UserModel insert(UserModel user){
        try {
            String insertStatement = "insert into users (name,password,e-mail) VALUES (?,?,?)";
            PreparedStatement preparedStatement=databaseOperations.getConnection().prepareStatement(insertStatement);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.execute();
            return user;//for debuging insert
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
