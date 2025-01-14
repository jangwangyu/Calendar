package com.study.calendarapp.exception;

public class InvalidEventException extends RuntimeException{
    public InvalidEventException(String message){
        super(message);
    }
}
