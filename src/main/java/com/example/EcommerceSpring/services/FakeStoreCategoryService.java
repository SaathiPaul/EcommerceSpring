package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import com.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;


@Service
public class FakeStoreCategoryService implements ICategoryService {

    private final ICategoryGateway categoryGateway; // DEPENDENCY INVERSION

    public FakeStoreCategoryService(
            @Qualifier("fakeStoreTemplateGateway") ICategoryGateway _categoryGateway)
    {
        this.categoryGateway = _categoryGateway;
    } // Dependency Injection

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> list = this.categoryGateway.getAllCategories();
        return list;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO)
    {
        return null;
    }

    public CategoryDTO getByName(String name) throws Exception
    {
        return null;
    }

    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception
    {
        return null;
    }

}