package Interface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import ContentProvider.CategoryModel;
import ContentProvider.ProductDataModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api?query=%7B%20collections(first%3A%2010)%20%7B%20edges%20%7B%20cursor%20node%20%7B%20id%20handle%20title%20description%20image%20%7B%20id%20url%20%7D%20%7D%20%7D%20%7D%7D")
    Call<CategoryModel> getCategories();
}
