package Fragments;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.tmtshop.R;

import java.util.ArrayList;
import java.util.List;

import ContentProvider.ImageAdapter;
import ContentProvider.ProductAdapter;
import ContentProvider.ProductDataModel;

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
        LinearLayoutManager productLinearLayoutManager = new LinearLayoutManager(getActivity());
        //Slider
        slideRecyclerView = view.findViewById(R.id.home_slider);
        slideRecyclerView.setLayoutManager(slideLinearLayoutManager);
        slideLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(slideRecyclerView);

        //Product
        productRecyclerView = view.findViewById(R.id.home_recycler_view);

        productRecyclerView.setLayoutManager(productLinearLayoutManager);
        productLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        int[] slideData = getSlideData();
        ImageAdapter imageAdapter = new ImageAdapter(getContext(), slideData);
        slideRecyclerView.setAdapter(imageAdapter);


        List<ProductDataModel> productData =  getData();
        ProductAdapter adapter = new ProductAdapter(getContext(),productData);
        productRecyclerView.setAdapter(adapter);

    }

    public int[] getSlideData()
    {
        int[] imageIDs= {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5};
        return imageIDs;
    }

    public List<ProductDataModel> getData(){
        List<ProductDataModel> productData = new ArrayList<>();
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_khoac.jpg"), "Áo khoác nam", 150000 , 4.6, 86));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_thun.jpg"), "Áo thun nam", 100000 , 2.6, 14));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_khoac.jpg"), "Áo khoác nam", 150000 , 4.6, 86));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_thun.jpg"), "Áo thun nam", 100000 , 2.6, 14));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_khoac.jpg"), "Áo khoác nam", 150000 , 4.6, 86));
        productData.add(new ProductDataModel(ProductDataModel.convertStringToBitmapFromAccess(getContext(), "ao_thun.jpg"), "Áo thun nam", 100000 , 2.6, 14));


        return productData;
    }
}