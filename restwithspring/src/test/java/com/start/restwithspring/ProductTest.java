package com.start.restwithspring;

import com.start.restwithspring.entity.Product;
import com.start.restwithspring.exception.ProductPriceException;
import com.start.restwithspring.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Autowired
    private ProductService productService;

    Product product = new Product();

    @Test
    public void verifyNegativeValueProduct() throws Exception {
        product.setName("Chocolate");
        product.setPrice(-19.0);
        product.setDescription("Chocolate Belga Amargo.");

        productService.save(product);

        assertThrows(ProductPriceException.class, ()->productService.save(product));



    }

    @Test
    public void falseTest(){
        Product product = new Product();

        if(product.getPrice() == 0){
            assertFalse(true);
        }
    }

}
