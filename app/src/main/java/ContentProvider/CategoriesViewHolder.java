package ContentProvider;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmtshop.R;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    ImageView imgView;
    TextView textView;

    public CategoriesViewHolder(@NonNull View itemView) {
        super(itemView);
        imgView = itemView.findViewById(R.id.category_image);
        textView = itemView.findViewById(R.id.category_title);
    }
}
