package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> list= new ArrayList<>();
        for(Category category : repo.findAll()) // SELECT * FROM category;
        {
            list.add(CategoryMapper.toDto(category));
        }
        System.out.println(list);
        return list;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO)
    {
        Category category = CategoryMapper.toEntity(categoryDTO); // createdat, updatedat, name
        Category saved = repo.save(category);
        return CategoryMapper.toDto(category);
    }

   public CategoryDTO getByName(String name) throws Exception
   {
       Category category = repo.findByName(name)
               .orElseThrow(() -> new Exception("Category Not found"));
       return CategoryMapper.toDto(category);
   }

}