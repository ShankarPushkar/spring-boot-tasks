package com.stackroute.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalListener extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<Object> handleConflict(
//            RuntimeException ex, WebRequest request) {
//        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
//    }
//    @ExceptionHandler(TrackAlreadyExistException.class)
//    protected ResponseEntity<Object> handleConflict1(
//            RuntimeException ex, WebRequest request) {
//        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler( TrackNotFoundException.class)
//    protected ResponseEntity<Object> handleConflict2(
//            RuntimeException ex, WebRequest request) {
//        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
//    }
@ExceptionHandler(value
        = {TrackAlreadyExistException.class, TrackNotFoundException.class})
protected ResponseEntity<Object> handleConflict(
        Exception ex, WebRequest request) {
    String bodyOfResponse = "This class is for the global exception controller";
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
}
}

