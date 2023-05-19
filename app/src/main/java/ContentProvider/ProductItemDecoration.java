package ContentProvider;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProductItemDecoration extends RecyclerView.ItemDecoration {
    private int spacing;
    private boolean includeEdge;

    public ProductItemDecoration(int spacing, boolean includeEdge) {
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int spanCount = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();

        if (includeEdge) {
            outRect.left = spacing - position % spanCount * spacing / spanCount;
            outRect.right = (position % spanCount + 1) * spacing / spanCount;

            if (position < spanCount) {
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        } else {
            outRect.left = position % spanCount * spacing / spanCount;
            outRect.right = spacing - (position % spanCount + 1) * spacing / spanCount;
            if (position >= spanCount) {
                outRect.top = spacing;
            }
        }
    }
}