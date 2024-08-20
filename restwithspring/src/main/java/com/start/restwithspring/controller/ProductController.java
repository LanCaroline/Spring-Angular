package com.start.restwithspring.controller;
import com.start.restwithspring.entity.Product;
import com.start.restwithspring.exception.ProductNullException;
import com.start.restwithspring.exception.ProductPriceException;
import com.start.restwithspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {


    @Autowired
    private ProductService service;
    //@RequestMapping(method = RequestMethod.GET, value = "/save")
    @PostMapping(value = "/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws Exception{

        return ResponseEntity.ok().body(service.save(product));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<Product>> getListProduct(){
        return ResponseEntity.ok().body(service.findAll());
    }



}
