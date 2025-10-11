package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;
//import jdk.jfr.Category;

public class ProductMapper {
    public static ProductDTO toDto(Product product)
    {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .image(product.getImage())
                .rating(product.getRating())
                .build();
    }

    public static Product toEntity(ProductDTO dto , Category category)
    {
        return Product.builder()
//                .id(dto.getId())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .image(dto.getImage())
                .rating(dto.getRating())
                .category(category)
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product)
    {
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .image(product.getImage())
                .rating(product.getRating())
                .category(CategoryMapper.toDto(product.getCategory()))
                .build();
    }

}