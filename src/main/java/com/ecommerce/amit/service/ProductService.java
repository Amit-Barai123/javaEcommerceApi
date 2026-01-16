package com.ecommerce.amit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.amit.dto.ProductReqDto;
import com.ecommerce.amit.dto.ProductResDto;

@Service
public interface ProductService {
    ProductResDto createProduct(ProductReqDto req); 
    List<ProductResDto> getProductsByCategory(Integer categoryId);
}
