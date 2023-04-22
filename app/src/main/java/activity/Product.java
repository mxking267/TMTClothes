package activity;

import androidx.annotation.NonNull;

public class Product {
    String tenAo, giaAo, danhGia,reViews;
    int imgAo, imgStar;

    public Product(String tenAo, String giaAo, String danhGia, String reViews) {
        this.tenAo = tenAo;
        this.giaAo = giaAo;
        this.danhGia = danhGia;
        this.reViews = reViews;
    }

    public String getTenAo() {
        return tenAo;
    }

    public String getGiaAo() {
        return giaAo;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public String getReViews() {
        return reViews;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
