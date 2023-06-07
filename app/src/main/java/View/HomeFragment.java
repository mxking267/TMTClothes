package View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmtshop.databinding.FragmentHomeBinding;

import Adapter.CategoriesaAdapter;
import Adapter.ImageAdapter;
import Adapter.ProductAdapter;
import Utils.ProductItemDecoration;
import ViewModel.CategoryViewModel;
import ViewModel.ProductViewModel;
import ViewModel.SlideViewModel;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    CategoryViewModel categoryViewModel = new CategoryViewModel(getContext());
    ProductViewModel productViewModel = new ProductViewModel(getContext());
    SlideViewModel slideViewModel = new SlideViewModel(getContext());




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

        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);



        //Slider
        binding.homeSlider.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.homeSlider);

        //Category
        binding.homeCategories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));


        //Product
        binding.homeProductRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, true));
        ProductItemDecoration itemDecoration = new ProductItemDecoration(20, true);
        binding.homeProductRecyclerView.addItemDecoration(itemDecoration);



        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.homeSlider.setAdapter(new ImageAdapter(getContext(), slideViewModel.getSlideData()));
        binding.homeProductRecyclerView.setAdapter(new ProductAdapter(getContext(), productViewModel.getAllProducts()));
        binding.homeCategories.setAdapter(new CategoriesaAdapter(getContext(),categoryViewModel.getCategories()));
    }


}