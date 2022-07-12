package com.x.assignment.controller;

import com.x.assignment.dto.ProductResponseDTO;
import com.x.assignment.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/productCalculator")
    public ResponseEntity<ProductResponseDTO> getProductSummary(@RequestParam  Integer noOfPenguinEar, @RequestParam Integer noHorseShoe) {
        // create a dto for parameter
        ProductResponseDTO responseDTO = productService.getProductDetails(noOfPenguinEar,noHorseShoe);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
