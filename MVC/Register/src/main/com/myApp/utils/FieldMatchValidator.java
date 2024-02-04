package main.com.myApp.utils;

import main.com.myApp.annotation.FieldMatch;
import main.com.myApp.model.UserModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch,Object> {
    @Override
    public boolean isValid( final Object o,final ConstraintValidatorContext constraintValidatorContext) {
       try {
           UserModel userModel = (UserModel) o;

           return userModel.getPassword().equals(userModel.getConfirmPassword());
       }catch (final Exception i){
           i.printStackTrace();
       }

       return true;


    }
}
