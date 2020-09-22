package com.ca.springdatajpadtoexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionController {
    @ExceptionHandler(value = GenericNotFoundException.class)
    public ResponseEntity<Object> exception(GenericNotFoundException exception) {
        return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
    }
}
