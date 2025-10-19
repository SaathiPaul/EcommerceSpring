package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService _categoryService)
    {
        this.categoryService = _categoryService;
    }

    @GetMapping //("/{id}")
    public ResponseEntity<?> getAllCategoriesController(@RequestParam(required = false) String name) throws Exception
    {
        if(name != null && !name.isBlank())
        {
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }
        else {
            List<CategoryDTO> result = this.categoryService.getAllCategories();
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO)
    {
        CategoryDTO created = categoryService.createCategory(categoryDTO); // name
        return ResponseEntity.status(201).body(created);
    }

}