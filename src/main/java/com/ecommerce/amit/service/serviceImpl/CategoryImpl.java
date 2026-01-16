package com.ecommerce.amit.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.amit.repo.CategoryRepo;
import com.ecommerce.amit.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryRepo repo;

    @Override
    public int createCategory(String name) {

        com.ecommerce.amit.entity.Category category = com.ecommerce.amit.entity.Category.builder().name(name).build();
       Integer Id = repo.save(category).getId();

       return Id;
    }

    @Override
    public void deleteCategory(Integer Id) {
     com.ecommerce.amit.entity.Category category=   repo.findById(Id).orElseThrow(()->new RuntimeException("category doesnot exists"));
     if(category !=null){
        repo.deleteById(Id);
       // repo.delete(category);
     }
    }
    
}
