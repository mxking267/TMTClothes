package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmtshop.databinding.GridProductBinding;

import java.util.List;

import Model.ProductModel;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    GridProductBinding binding;
    private Context context;
    private List<ProductModel> products;


    public ProductAdapter(Context context, List<ProductModel> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = GridProductBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        ProductModel productModel = products.get(position);
        holder.bind(productModel);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
