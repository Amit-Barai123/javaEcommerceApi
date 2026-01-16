package com.ecommerce.amit.service;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
   
    int createCategory(String name);
    void deleteCategory(Integer Id);
    
}
