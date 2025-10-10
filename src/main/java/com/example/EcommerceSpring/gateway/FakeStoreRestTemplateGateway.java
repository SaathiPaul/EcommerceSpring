package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.mappers.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("fakeStoreTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products/categories";

        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate.getForEntity(url , FakeStoreCategoryResponseDTO.class);

        if(response.getBody() == null || response.getBody().getCategories() == null )
        {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        List<String> categories = response.getBody().getCategories();
        List<CategoryDTO> list = new ArrayList<>();

//        for (String singleCategory : categories) {
//            CategoryDTO dto = new CategoryDTO();
//            dto.setName(singleCategory);
//            list.add(dto);
//        }
//
//        return list;

        return GetAllCategoriesMapper.toCategoryDTO(response.getBody());

    }
}



