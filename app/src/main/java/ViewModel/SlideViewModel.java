package ViewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.tmtshop.R;

public class SlideViewModel extends ViewModel {
    public Context getContext() {
        return context;
    }

    Context context;

    public SlideViewModel(Context context) {
        this.context = context;
    }

    public int[] getSlideData() {
        return new int[]{R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5};
    }
}
