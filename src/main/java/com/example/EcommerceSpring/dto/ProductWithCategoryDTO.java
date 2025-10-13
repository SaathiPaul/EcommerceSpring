package com.example.EcommerceSpring.dto;


import jakarta.persistence.Entity;
import lombok.*;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithCategoryDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private Rating rating;
    private Long categoryId;
    private CategoryDTO category;
}
