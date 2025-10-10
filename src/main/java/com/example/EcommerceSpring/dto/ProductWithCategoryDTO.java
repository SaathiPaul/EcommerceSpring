package com.example.EcommerceSpring.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDTO {

    private String title;
    private double price;
    private String description;
    private String image;
    private Rating rating;

    private CategoryDTO category;
}
