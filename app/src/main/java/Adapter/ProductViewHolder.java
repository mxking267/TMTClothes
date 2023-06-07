package Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tmtshop.databinding.GridProductBinding;

import Model.ProductModel;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    GridProductBinding binding;

    public ProductViewHolder(@NonNull GridProductBinding binding) {
        super(binding.getRoot());
        this.binding = binding;

    }

    public void bind(ProductModel productModel)
    {
        binding.setProduct(productModel);
        Glide.with(binding.productImage.getContext().getApplicationContext())
                .load(productModel.getImageUrl())
                .into(binding.productImage);
        binding.executePendingBindings();
    }
}
