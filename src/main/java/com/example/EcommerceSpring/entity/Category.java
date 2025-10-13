package com.example.EcommerceSpring.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Column(nullable = false , unique = true)
    private String name;


    // one category has many products
    // this does not mean that you are trying to store a list of product inside category table
    // telling jpa , the relationship is already owned by the product entity , So just read from there.
    @OneToMany(mappedBy = "category")
    private List<Product> product;
}
