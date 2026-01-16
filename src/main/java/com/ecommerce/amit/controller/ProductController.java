package com.ecommerce.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.amit.dto.ProductReqDto;
import com.ecommerce.amit.dto.ProductResDto;
import com.ecommerce.amit.service.ProductService;

@RestController
@RequestMapping("/admin")
public class ProductController {
    
    @Autowired
    private  ProductService service;

    @PostMapping("/create-product")
    public  ResponseEntity< ProductResDto> createProduct(@RequestBody ProductReqDto req){

        ProductResDto resdto =service.createProduct(req);

        return ResponseEntity.ok(resdto);
    }

    @GetMapping("/get-products/{categoryId}")
    public ResponseEntity<List<ProductResDto>> getProductsByCategory(@PathVariable Integer categoryId){
List<ProductResDto> reqDtos = service.getProductsByCategory(categoryId);

return ResponseEntity.ok(reqDtos);
    }

}
