package activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tmtshop.R;

import java.util.ArrayList;

public class ProductSaleAdapter extends BaseAdapter {

    Context context;

    ArrayList<ProductSale> items;

    public ProductSaleAdapter(Context context, ArrayList<ProductSale> items) {
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

    public void add(ProductSale productSale){
        items.add(productSale);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(context);
        View layout = li.inflate(R.layout.grid_product_sale,null);

        TextView tenAoSale = layout.findViewById(R.id.gvs_ten_ao_thun_1);
        tenAoSale.setText(items.get(i).getTenAoSale());

        TextView giaSale = layout.findViewById(R.id.gvs_gia_sale);
        giaSale.setText(items.get(i).getGiaSale());

        TextView giaGoc = layout.findViewById(R.id.gvs_gia_goc);
        giaGoc.setText(items.get(i).getGiaGoc());

        TextView dgSale = layout.findViewById(R.id.tv_some_id);
        dgSale.setText(items.get(i).getDanhGiaSale());

        TextView rvSale = layout.findViewById(R.id.tv_reviews);
        rvSale.setText(items.get(i).getReviewSale());

        return layout;
    }
}
