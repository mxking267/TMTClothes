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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ContentProvider.CategoriesaAdapter;
import ContentProvider.CategoryModel;
import ContentProvider.ImageAdapter;
import ContentProvider.ProductAdapter;
import ContentProvider.ProductDataModel;
import ContentProvider.ProductItemDecoration;
import Interface.ApiService;
import Network.API;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView productRecyclerView, slideRecyclerView, categoriesRecyclerView;
    List<CategoryModel.Data.Collection.Edges.Node> categories = new ArrayList<>();
    CategoriesaAdapter categoriesAdapter;



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
        GridLayoutManager categoriesGridLayoutManger =new GridLayoutManager(getActivity(),1);

        //Fake API



        //Slider
        slideRecyclerView = view.findViewById(R.id.home_slider);
        slideRecyclerView.setLayoutManager(slideLinearLayoutManager);
        slideLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(slideRecyclerView);

        //Category
        categoriesRecyclerView = view.findViewById(R.id.home_categories);
        categoriesAdapter = new CategoriesaAdapter(getContext(), categories);
        categoriesRecyclerView.setLayoutManager(categoriesGridLayoutManger);categoriesGridLayoutManger.setOrientation(RecyclerView.HORIZONTAL);

        //Product
        productRecyclerView = view.findViewById(R.id.home_product_recycler_view);;
        productRecyclerView.setLayoutManager(productGridLayoutManager);
        productGridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ProductItemDecoration itemDecoration = new ProductItemDecoration(20, true);
        productRecyclerView.addItemDecoration(itemDecoration);





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
             for (int i = 0;i<response.body().getData().getCollection().getEdge().size(); i++)
             {
                 categories.add(response.body().getData().getCollection().getEdge().get(i).getNode());
             }
             categoriesRecyclerView.setAdapter(categoriesAdapter);

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