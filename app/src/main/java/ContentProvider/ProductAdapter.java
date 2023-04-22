package ContentProvider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmtshop.R;

import java.util.ArrayList;
import java.util.List;

import activity.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private Context context;
    private List<ProductDataModel> products;


    public ProductAdapter(Context context, List<ProductDataModel> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.grid_product, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(productView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.img.setImageBitmap(products.get(position).image);
        holder.title.setText(products.get(position).title);
        holder.price.setText(String.valueOf(products.get(position).price));
        holder.rating.setText(String.valueOf(products.get(position).rating));
        holder.reviews.setText(String.valueOf(products.get(position).reviews) + " Reviews");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
