package ContentProvider;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;

public class ProductDataModel {
    Bitmap image;
    String title;
    int price, reviews;
    double rating;

    public ProductDataModel(Bitmap image, String title, int price, double rating, int reviews) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public static Bitmap convertStringToBitmapFromAccess(Context context, String filename) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(filename);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
