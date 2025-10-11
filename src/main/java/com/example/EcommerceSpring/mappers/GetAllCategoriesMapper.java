package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class GetAllCategoriesMapper {

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryDTO() {
        return null;
    }



    public static List<CategoryDTO> toCategoryDTO(FakeStoreCategoryResponseDTO dto) {
        List<CategoryDTO> list = new ArrayList<>();
        if (dto.getCategories() != null) {
            for (String name : dto.getCategories()) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(name);
                list.add(categoryDTO);
            }
        }
        return list;
    }

//    public static List<CategoryDTO> toCategoryDTO(FakeStoreProductResponseDTO dto)
//    {
//        List<CategoryDTO> list = new ArrayList<>();
//        List<String> response = dto.getCategory();
//        for (int i = 0; i < response.size(); i++) {
//            String singleCategory = response.get(i);
//            CategoryDTO CategoryDTO = new CategoryDTO();
//            CategoryDTO.setName(singleCategory);
//            list.add(CategoryDTO);
//        }
//
//        return list;
//    }

}
