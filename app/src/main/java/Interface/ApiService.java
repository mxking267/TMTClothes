package Interface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Model.ApiModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd-HH:mm:ss").create();



    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @GET("v1/c3fdae7c-43f3-4fde-b254-6e10f2f50a24")
    Call<ApiModel> getCategories();

    @GET("v1/b51f63a4-4e61-4998-86fe-b7688667e3be")
    Call<ApiModel> getAllProducts();


}

