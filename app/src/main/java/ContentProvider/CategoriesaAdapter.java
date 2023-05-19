package ContentProvider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tmtshop.R;

import java.util.List;

public class CategoriesaAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {
    private Context context;
    private List<CategoryModel.Data.Collection.Edges.Node> categories;

    public CategoriesaAdapter(Context context, List<CategoryModel.Data.Collection.Edges.Node> categories) {
        this.context = context;
        this.categories = categories;
    }


    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View categoryView = inflater.inflate(R.layout.category_layout, parent, false);
         CategoriesViewHolder viewHolder = new CategoriesViewHolder(categoryView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        holder.textView.setText(categories.get(position).getTitle());
        Glide.with(context.getApplicationContext())
                .load(categories.get(position).getImage().getUrl())
                .into(holder.imgView);
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
