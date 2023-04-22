package activity;

import androidx.annotation.NonNull;

public class ProductSale {
    String tenAoSale, giaSale, giaGoc, danhGiaSale, reviewSale;

    public ProductSale(String tenAoSale, String giaSale, String giaGoc, String danhGiaSale, String reviewSale) {
        this.tenAoSale = tenAoSale;
        this.giaSale = giaSale;
        this.giaGoc = giaGoc;
        this.danhGiaSale = danhGiaSale;
        this.reviewSale = reviewSale;
    }

    public String getTenAoSale() {
        return tenAoSale;
    }

    public String getGiaSale() {
        return giaSale;
    }

    public String getGiaGoc() {
        return giaGoc;
    }

    public String getDanhGiaSale() {
        return danhGiaSale;
    }

    public String getReviewSale() {
        return reviewSale;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
