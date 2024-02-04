package main.com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import main.com.myApp.annotation.FieldMatch;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Annotation;
@Component
@Setter
@Getter
@FieldMatch(first = "password",second = "confirmPassword",message = "does not match")
public class UserModel {
    @NotEmpty(message = "enter your name")
    private String  userName;

    @NotEmpty(message = "enter a password ")
    private String password;

    @NotEmpty(message = "confirm your password")
    private String confirmPassword;

    @NotEmpty(message = "enter your email")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n",message = "Please,enter a valid email")
    private String email;



    }

