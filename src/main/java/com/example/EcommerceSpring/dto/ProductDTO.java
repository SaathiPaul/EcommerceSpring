package com.example.EcommerceSpring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private long id;
    private String title;
    private double price;
    private String description;
    private long categoryId;
    private String image;
    private Rating rating;
}