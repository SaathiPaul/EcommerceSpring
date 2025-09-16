package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        // 1 .make the http request to the fakestore API to fetch the details

         FakeStoreCategoryResponseDTO response = this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();

        //2. check if the response is null and tr=hrow an IOException if it is
//        if(response == null)
//        {
//            throw new IOException("Failed to fetch categories from Fakestore API");
//        }


        //3. map the response to a list of CategoryDTO objects

        List<CategoryDTO> list = new ArrayList<>();
//        List<String> fetchedCategories = response.getCategories();
//        for (int i = 0; i < fetchedCategories.size(); i++) {
//            String cat = fetchedCategories.get(i);
//            CategoryDTO dto = CategoryDTO.builder().name(cat).build();
//            list.add(dto);
//        }
        CategoryDTO dto = CategoryDTO.builder().name("gaming").build();
        CategoryDTO dto1 = CategoryDTO.builder().name("cloth").build();
        CategoryDTO dto2 = CategoryDTO.builder().name("cosmetics").build();

        list.add(dto);
        list.add(dto1);
        list.add(dto2);

        return list;
    }
}
