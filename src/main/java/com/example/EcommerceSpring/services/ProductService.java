package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.exception.CategoryNotFoundException;
import com.example.EcommerceSpring.exception.ProductNotFoundException;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import com.example.EcommerceSpring.repository.ProductRepository;
import com.example.EcommerceSpring.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo , CategoryRepository categoryRepository)
    {
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO getProductById(Long id) throws Exception
    {
        return repo.findById(id)
            .map(ProductMapper::toDto)
                .orElseThrow(()-> new ProductNotFoundException(("Product with ID" +id+ " not found")));
    }


    @Override
    public ProductDTO createProduct(ProductDTO dto)
    {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Product productEntity = ProductMapper.toEntity(dto , category);

        Product saved = repo.save(productEntity);
        return ProductMapper.toDto(saved);
    }


    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception
    {
        Product product = repo.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        return ProductMapper.toProductWithCategoryDTO(product);
    }
}
