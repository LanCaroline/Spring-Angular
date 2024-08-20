package com.start.restwithspring.service;

import com.start.restwithspring.entity.Product;
import com.start.restwithspring.exception.ProductNullException;
import com.start.restwithspring.exception.ProductPriceException;
import com.start.restwithspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) throws Exception{
        if(product.getName() == null || product.getPrice() == null){
            throw new ProductNullException();
        }
        if(product.getPrice() < 0){
            throw new ProductPriceException();
        }
        return repository.save(product);
    }

    public Product findById(Long id){
        return repository.findById(id).orElse(null);

    }

    public List<Product> findAll(){
        return repository.findAll();
    }
}
