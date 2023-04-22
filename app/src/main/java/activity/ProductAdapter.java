package activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tmtshop.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    Context context;
    ArrayList<Product> items;

    public ProductAdapter(Context context, ArrayList<Product> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void add(Product product){
        items.add(product);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(context);
        View layout = li.inflate(R.layout.grid_product,null);

        TextView tenAo = layout.findViewById(R.id.gv_ten_sp);
        tenAo.setText(items.get(i).getTenAo());

        TextView giaAo = layout.findViewById(R.id.gv_gia_ao);
        giaAo.setText(items.get(i).getGiaAo());

        TextView danhGia = layout.findViewById(R.id.gv_so_sao);
        danhGia.setText(items.get(i).getDanhGia());

        TextView reViews = layout.findViewById(R.id.gv_reviews);
        reViews.setText(items.get(i).getReViews());

        return layout;
    }
}
