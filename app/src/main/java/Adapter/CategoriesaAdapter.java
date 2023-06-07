package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmtshop.databinding.CategoryLayoutBinding;

import java.util.List;

import Model.CategoriesModel;

public class CategoriesaAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {
    private Context context;
    private List<CategoriesModel> categories;
    CategoryLayoutBinding binding;

    public CategoriesaAdapter(Context context, List<CategoriesModel> categories) {
        this.context = context;
        this.categories = categories;
    }


    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CategoryLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return  new CategoriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        CategoriesModel categoriesModel = categories.get(position);
        holder.bind(categoriesModel);

    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


}
