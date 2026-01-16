package com.ecommerce.amit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReqDto {
     private String name;

    private String description;

    private Double price;

    private Integer stock;

    private Integer categoryId;
}
