package com.ecommerce.amit.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CartItemsReq {
   
    private Integer cartId;
    private Integer productId;
    private Integer quantity;
    
}
