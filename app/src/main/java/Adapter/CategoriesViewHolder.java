
package Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tmtshop.databinding.CategoryLayoutBinding;

import Model.CategoriesModel;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    CategoryLayoutBinding binding;

    public CategoriesViewHolder(@NonNull CategoryLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;

    }


    public void bind(CategoriesModel categoriesModel)
    {
        binding.setCategory(categoriesModel);
        Glide.with(binding.categoryImage.getContext().getApplicationContext())
                .load(categoriesModel.getUrl())
                .into(binding.categoryImage);
        binding.executePendingBindings();
    }
}
