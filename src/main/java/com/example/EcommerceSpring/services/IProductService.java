package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;

import java.util.List;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;

    ProductDTO createProduct(ProductDTO dto);

    List<ProductWithCategoryDTO> getProductWithCategory() throws Exception;
}