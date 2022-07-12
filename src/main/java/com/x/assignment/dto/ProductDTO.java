package com.x.assignment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {

    String itemType;
    int noOfUnit;
    double noOfCarton;
    double singleUnit;
    double cost;
    double discountedCost;

    public ProductDTO(String itemType, int noOfUnit, double noOfCarton, double singleUnit, double cost, double discountedCost) {
        this.itemType = itemType;
        this.noOfUnit = noOfUnit;
        this.noOfCarton = noOfCarton;
        this.singleUnit = singleUnit;
        this.cost = cost;
        this.discountedCost = discountedCost;
    }
}
