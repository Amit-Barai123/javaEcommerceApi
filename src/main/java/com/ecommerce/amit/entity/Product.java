package com.ecommerce.amit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
