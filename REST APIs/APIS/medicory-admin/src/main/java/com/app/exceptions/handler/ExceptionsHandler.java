package com.app.exceptions.handler;

import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.exceptions.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerOfEntityNotFoundException(EntityNotFoundException exception){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
   @ExceptionHandler(EmptyRequestException.class)
    public ResponseEntity<ErrorResponse> handlerForRequestEmptyException(EmptyRequestException exception){
        ErrorResponse errorResponse =new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),System.currentTimeMillis());
       return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

   }
   @ExceptionHandler(DataConflictException.class)
    public ResponseEntity<ErrorResponse> handlerForDataConflictException(DataConflictException exception){
       ErrorResponse errorResponse =new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage(),System.currentTimeMillis());
       return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
   }

}
