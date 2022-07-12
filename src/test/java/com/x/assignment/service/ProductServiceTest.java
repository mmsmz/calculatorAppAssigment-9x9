package com.x.assignment.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

    @InjectMocks
    ProductServiceImpl  productService;

    @Test
    void getProductDetailsTest(){

        productService.getProductDetails(25,60);
    }

}
