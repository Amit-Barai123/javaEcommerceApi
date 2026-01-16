package com.ecommerce.amit.service.serviceImpl;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.amit.dto.ProductReqDto;
import com.ecommerce.amit.dto.ProductResDto;
import com.ecommerce.amit.entity.Product;
import com.ecommerce.amit.repo.CategoryRepo;
import com.ecommerce.amit.repo.ProductRepo;
import com.ecommerce.amit.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductResDto createProduct(ProductReqDto req) {
       com.ecommerce.amit.entity.Category category = categoryRepo.findById(req.getCategoryId()).orElseThrow(()->new RuntimeException("category not Found"));

       Product product = Product.builder().
       name(req.getName())
       .description(req.getDescription())
       .price(req.getPrice())
       .stock(req.getStock())
       .category(category)
       .build();
        Product savedProduct=  productRepo.save(product);

        ProductResDto resDto = ProductResDto.builder()
        .name(savedProduct.getName())
        .description(savedProduct.getDescription())
        .price(savedProduct.getPrice())
        .stock(savedProduct.getStock())
        .categoryName(savedProduct.getCategory().getName())
        .build();

        return resDto;

       
    }

    @Override
    public List<ProductResDto> getProductsByCategory(Integer categoryId) {
       com.ecommerce.amit.entity.Category category = categoryRepo.findById(categoryId).orElseThrow(()->new RuntimeException("category not Found"));
       
       List<Product> products = productRepo.findByCategory(category);

       List<ProductResDto> productResDtos = products.stream().map(e->{

        ProductResDto resDto = ProductResDto.builder()
        .name(e.getName())
        .description(e.getDescription())
        .price(e.getPrice())
        .stock(e.getStock())
        .categoryName(e.getCategory().getName())
        .build();

        return resDto;

       }).toList();
       return productResDtos;
    }
}