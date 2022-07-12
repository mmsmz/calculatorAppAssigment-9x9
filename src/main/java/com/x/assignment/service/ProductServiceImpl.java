package com.x.assignment.service;

import com.x.assignment.dto.ProductDTO;
import com.x.assignment.dto.ProductResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Value("${product.penguinears.carton.Units}")
    private int penguinCartonUnits;

    @Value("${product.penguinears.carton.price}")
    private double penguinCartonPrice;

    @Value("${product.horseshoe.carton.units}")
    private int horseShoeCartonUnits;

    @Value("${product.horseshoe.carton.price}")
    private double horseShoeCartonPrice;

    @Override
    public ProductResponseDTO getProductDetails(Integer noOfPenguinEar, Integer horseShoe) {

        double laborCost = 1.3;
        double discountCarton = 0.9;

        int cartonUnits = 0;
        double cartonPrice = 0;

        String[] productName = {"PenguinEar", "horseShoe"};
        List<ProductDTO> list = new ArrayList<>();
        double totalPrice = 0;

        for (int i = 0; i < productName.length; i++) {
            if (productName[i].equals("PenguinEar")) {
                cartonUnits = penguinCartonUnits;
                cartonPrice = penguinCartonPrice;
            } else if (productName[i].equals("horseShoe")) {
                cartonUnits = horseShoeCartonUnits;
                cartonPrice = horseShoeCartonPrice;
            }

            if (noOfPenguinEar != null) {
                int noOfCarton = noOfPenguinEar / cartonUnits;
                double singleUnit = noOfPenguinEar % cartonUnits;
                double cost = (noOfCarton * cartonPrice) + singleUnit * (cartonPrice / cartonUnits) * laborCost;
                double discountCost = noOfPenguinEar >= 60 ? cost * discountCarton : cost;
                totalPrice += discountCost;
                list.add(new ProductDTO(productName[i], noOfPenguinEar, noOfCarton, singleUnit, cost, discountCost));
            }
        }

        return ProductResponseDTO.builder().productDTO(list).totalPriceOfProducts(totalPrice).build();
    }
}
