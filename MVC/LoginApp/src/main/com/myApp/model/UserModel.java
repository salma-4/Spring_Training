package main.com.myApp.model;

import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


import java.util.List;

@Setter
@Getter
@Component
public class UserModel {

    @NotEmpty(message = "Username is required")
    private String userName;

    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
            message = "Enter a valid password with at least 8 characters, including uppercase, lowercase, digit, and special character")
    private String password;

    @Pattern(regexp = "^(.+)@(\\S+)$", message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Salary is required")
    private String salary;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Programming preference is required")
    private String prefProgramming;

    @NotEmpty(message = "At least one operating system must be selected")
    private List<String> operatingSystem;

}
