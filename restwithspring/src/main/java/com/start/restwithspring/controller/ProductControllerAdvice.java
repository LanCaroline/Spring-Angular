package com.start.restwithspring.controller;

import com.start.restwithspring.exception.ProductNullException;
import com.start.restwithspring.exception.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> getError(){
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Product Exception - Generic Error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

    }

    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> getNullError(){
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Check product fields");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> getIlegalProductPrice(){
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Check product price");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


}
