package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService _categoryService)
    {
        this.categoryService = _categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getCategories() throws IOException
    {
        List<CategoryDTO> list =  this.categoryService.getAllCategories();
        return list;
    }

    @GetMapping("/vivek")
    public ResponseEntity<String> love() {
        return ResponseEntity.status(201).body("Vivek");
    }

}