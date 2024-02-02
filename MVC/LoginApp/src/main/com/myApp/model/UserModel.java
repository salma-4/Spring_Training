package main.com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
public class UserModel {
    private String userName;
    private String password;
    private String email;
    private String salary;
    private String country;
    private String prefProgramming ;
    private List<String> operatingSystem;



}
