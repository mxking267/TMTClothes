package ContentProvider;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmtshop.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
     ImageView img;
     TextView title, price, rating, reviews;
     View view;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.product_image);
        title = (TextView) itemView.findViewById(R.id.product_title);
        price = (TextView) itemView.findViewById(R.id.product_price);
        rating = (TextView) itemView.findViewById(R.id.product_rating);
        reviews = (TextView) itemView.findViewById(R.id.product_review);
        view = itemView;
    }
}
