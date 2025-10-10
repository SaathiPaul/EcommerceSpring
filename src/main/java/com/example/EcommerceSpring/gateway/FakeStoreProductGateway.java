package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.Rating;
import com.example.EcommerceSpring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreProductGateway implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;;
    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi)
    {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException
    {
        FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getAllFakeProduct(id).execute().body();
        if( response == null ) {
            throw new IOException("Product not found");
        }
        ProductDTO dto = new ProductDTO();

        dto.setId(response.getId());
        dto.setTitle(response.getTitle());
        dto.setPrice(response.getPrice());
        dto.setDescription(response.getDescription());
//        dto.setCategory(response.getCategory());
        dto.setImage(response.getImage());
        dto.setRating(response.getRating());


        return dto;
    }

}

