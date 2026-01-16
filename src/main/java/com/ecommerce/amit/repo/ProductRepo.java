package com.ecommerce.amit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.amit.entity.Category;
import com.ecommerce.amit.entity.Product;
import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    
    List<Product> findByCategory(Category category);

}
