package com.example.EcommerceSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {

    private String title;
    private double price;
    private String description;
    private String image;
//    private Rating rating;

    //Each product belongs to one category
    //One category can have many products
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id" , nullable = false)
    private Category category;
}