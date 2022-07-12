package com.x.assignment.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class ProductResponseDTO {

    private List<ProductDTO> productDTO;
    double totalPriceOfProducts;
    private String status;
    private String message;

    public ProductResponseDTO() {
        this.productDTO = new ArrayList<>();
    }

}
