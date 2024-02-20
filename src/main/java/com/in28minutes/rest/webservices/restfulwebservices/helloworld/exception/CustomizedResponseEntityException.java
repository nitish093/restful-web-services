package com.in28minutes.rest.webservices.restfulwebservices.helloworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomizedResponseEntityException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("message",methodArgumentNotValidException.getMessage());
        map.put("timestamp",System.currentTimeMillis());
        map.put("status", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValid(HttpMessageNotReadableException httpMessageNotReadableException)
    {
        Map<String,Object> map = new HashMap<>();

        map.put("message",httpMessageNotReadableException.getMessage());
        map.put("timestamp",System.currentTimeMillis());
        map.put("status", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
}
