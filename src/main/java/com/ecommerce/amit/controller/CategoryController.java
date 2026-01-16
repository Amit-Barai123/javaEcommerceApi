package com.ecommerce.amit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.amit.service.CategoryService;

@RestController
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService service;
    
    @PostMapping("/create")
     public ResponseEntity<Integer> createCategory( String name){

        Integer id= service.createCategory(name);
        return ResponseEntity.ok(id);

     }

     @DeleteMapping("/deleteCategory/{id}")
     public ResponseEntity<String> deleteCategory(@PathVariable Integer id){
      service.deleteCategory(id);

      return ResponseEntity.ok("deleted sucessfully");
     }

}
