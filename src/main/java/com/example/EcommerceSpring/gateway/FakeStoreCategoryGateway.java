package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway {

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        // 1 .make the http request to the fakestore API to fetch the details

//        Call<List<String>> response = fakeStoreCategoryApi.getAllFakeCategories();
//        List<String> res = response.execute().body();

        List<String> response = this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();


        System.out.println(response);
        System.out.println("vivek");

        //2. check if the response is null and throw an IOException if it is
        if(response == null) //[]
        {
            throw new IOException("Failed to fetch categories from Fakestore API");
        }


        //3. map the response to a list of CategoryDTO objects

        List<CategoryDTO> list = new ArrayList<>();
//        List<String> fetchedCategories = response.getCategories();
        for (int i = 0; i < response.size(); i++) {
            String singleCategory = response.get(i);
            CategoryDTO dto = new CategoryDTO();
            dto.setName(singleCategory);
            list.add(dto);

        }
        return list;

        // return GetAllCategoriesMapper.toCategoryDto(response);
    }
}
