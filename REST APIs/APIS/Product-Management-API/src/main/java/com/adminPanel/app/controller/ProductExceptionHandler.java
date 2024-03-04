package com.adminPanel.app.controller;

import com.adminPanel.app.exception.EmptyDataException;
import com.adminPanel.app.exception.ProductNotFoundException;
import com.adminPanel.app.exception.response.ProductErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handlerForProductNotFound(ProductNotFoundException exception){
        ProductErrorResponse errorResponse = new ProductErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handelerForEmptyData(EmptyDataException exception){
        ProductErrorResponse errorResponse = new ProductErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
