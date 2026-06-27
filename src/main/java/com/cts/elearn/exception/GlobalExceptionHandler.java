package com.cts.elearn.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatePurchaseException.class)
    public ResponseEntity<Map<String,String>> handleDuplicatePurchase(
            DuplicatePurchaseException ex){

        Map<String,String> response = new HashMap<>();

        response.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);

    }

}