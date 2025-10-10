package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.entity.Category;

public class CategoryMapper {
    public static CategoryDTO toDto(Category entity)
    {
        return  CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO dto)
    {
        return Category.builder()
                .name(dto.getName())
                .build();

    }

}
