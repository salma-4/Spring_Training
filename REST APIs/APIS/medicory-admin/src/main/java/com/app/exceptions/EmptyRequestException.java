package com.app.exceptions;

public class EmptyRequestException extends Exception{
    public EmptyRequestException(String message){
        super(message);
    }
}
