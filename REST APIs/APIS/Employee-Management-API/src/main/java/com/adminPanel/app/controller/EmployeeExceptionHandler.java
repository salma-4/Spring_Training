package com.adminPanel.app.controller;

import com.adminPanel.app.exception.EmployeeNotFoundException;
import com.adminPanel.app.exception.EmptyDataException;
import com.adminPanel.app.exception.response.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handlerForEmployeeNotFound(EmployeeNotFoundException exception){
     EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
       errorResponse.setCode(HttpStatus.NOT_FOUND.value());
       errorResponse.setMessage(exception.getMessage());
       errorResponse.setTimeStamp(System.currentTimeMillis());
       return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handlerForEmptyData(EmptyDataException exception){

        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
