package ViewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import Interface.ApiService;
import Model.ApiModel;
import Model.ProductModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends ViewModel {
    List<ProductModel> products = new ArrayList<>();

    public Context getContext() {
        return context;
    }

    Context context;

    public ProductViewModel(Context context) {
        this.context = context;
    }

    public List<ProductModel> getAllProducts()
    {
        ApiService.apiService.getAllProducts().enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                for (int i = 0; i < response.body().getData().getProduct().getEdges().size(); i++) {
                    products.add(
                            new ProductModel(
                                    response.body().getData().getProduct().getEdges().get(i).getNode().getTitle(),
                                    response.body().getData().getProduct().getEdges().get(i).getNode().getVariant().getEdges().get(0).getNode().getPrice().getAmount(),
                                    response.body().getData().getProduct().getEdges().get(i).getNode().getFeaturedImage().getUrl()
                            )
                    );
                }

            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {

            }
        });
        return products;
    }


}
