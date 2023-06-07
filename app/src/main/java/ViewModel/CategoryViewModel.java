package ViewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import Interface.ApiService;
import Model.ApiModel;
import Model.CategoriesModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends ViewModel {
    List<CategoriesModel> categories = new ArrayList<>();

    public Context getContext() {
        return context;
    }

    Context context;

    public CategoryViewModel(Context context) {
        this.context = context;
    }


    public List<CategoriesModel> getCategories() {
        ApiService.apiService.getCategories().enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                for (int i = 0; i < response.body().getData().getCollection().getEdge().size(); i++) {
                    categories.add(new CategoriesModel(
                            response.body().getData().getCollection().getEdge().get(i).getNode().getTitle(),
                            response.body().getData().getCollection().getEdge().get(i).getNode().getImage().getUrl()
                    ));
                }

            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {

            }
        });
        return categories;
    }

}
