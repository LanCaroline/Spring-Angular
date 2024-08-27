package com.start.restwithspring.controller;

import com.start.restwithspring.entity.Order;
import com.start.restwithspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

//    @Autowired
//    private OrderService service;
//
//    @PostMapping(value = "/save")
//    public ResponseEntity<Order> saveProduct(@RequestBody Order product){
//        return ResponseEntity.ok(service.save(product));
//    }
//
//    @PostMapping(value = "/{id}")
//    public ResponseEntity<Order> getProduct(@@PathVariable Long id){
//        return ResponseEntity.ok(service.get(id));
//    }



}
