package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tmtshop.R;

import java.util.ArrayList;
import java.util.List;

import ContentProvider.CategoryModel;
import ContentProvider.ImageAdapter;
import ContentProvider.ProductAdapter;
import ContentProvider.ProductDataModel;
import Interface.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    RecyclerView productRecyclerView, slideRecyclerView;



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayoutManager slideLinearLayoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager productGridLayoutManager = new GridLayoutManager(getActivity(), 2);

        //Fake API



        //Slider
        slideRecyclerView = view.findViewById(R.id.home_slider);
        slideRecyclerView.setLayoutManager(slideLinearLayoutManager);
        slideLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(slideRecyclerView);

        //Product
        productRecyclerView = view.findViewById(R.id.home_product_recycler_view);;
        productRecyclerView.setLayoutManager(productGridLayoutManager);
        productGridLayoutManager.setOrientation(RecyclerView.VERTICAL);




        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        int[] slideData = getSlideData();
        ImageAdapter imageAdapter = new ImageAdapter(getContext(), slideData);
        slideRecyclerView.setAdapter(imageAdapter);



        List<ProductDataModel> productData =  getProductData();
        ProductAdapter adapter = new ProductAdapter(getContext(),productData);
        productRecyclerView.setAdapter(adapter);

        ApiService.apiService.getCategories().enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                CategoryModel categoryModel = response.body();
                CategoryModel.Data data = categoryModel.getData();
                CategoryModel.Data.Collection.Edges.Node node = categoryModel.getData().getCollection().getEdge().get(1).getNode();
                Log.e( "onResponse: ", node.getTitle().toString() );
            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {

            }
        });
    }

    public int[] getSlideData()
    {
        int[] imageIDs= {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5};
        return imageIDs;
    }

    public List<ProductDataModel> getProductData(){

        List<ProductDataModel> productData = new ArrayList<>();
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_khoac.jpg"), "Áo khoác nam", 150000 , 4.6, 86));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_thun.jpg"), "Áo thun nam", 100000 , 2.6, 14));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_khoac.jpg"), "Áo khoác nam", 150000 , 4.6, 86));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_thun.jpg"), "Áo thun nam", 100000 , 2.6, 14));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_khoac.jpg"), "Áo khoác nam", 150000 , 4.6, 86));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_thun.jpg"), "Áo thun nam", 100000 , 2.6, 14));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_khoac.jpg"), "Áo khoác nam", 150000 , 4.6, 86));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_thun.jpg"), "Áo thun nam", 100000 , 2.6, 14));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_khoac.jpg"), "Áo khoác nam", 150000 , 4.6, 86));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_thun.jpg"), "Áo thun nam", 100000 , 2.6, 14));



        return productData;
    }
}