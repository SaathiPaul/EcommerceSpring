package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.ProductDTO;
import java.io.IOException;

public interface IProductGateway {

    ProductDTO getProductById(Long id) throws IOException;

}