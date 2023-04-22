package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tmtshop.R;

import java.util.ArrayList;
import java.util.List;

import ContentProvider.ProductAdapter;
import ContentProvider.ProductDataModel;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;


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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<ProductDataModel> productData =  getData();
        ProductAdapter adapter = new ProductAdapter(getContext(),productData);
        recyclerView.setAdapter(adapter);

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