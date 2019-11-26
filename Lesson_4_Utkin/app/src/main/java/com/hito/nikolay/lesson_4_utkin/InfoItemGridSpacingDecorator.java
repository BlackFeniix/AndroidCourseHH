package com.hito.nikolay.lesson_4_utkin;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class InfoItemGridSpacingDecorator extends RecyclerView.ItemDecoration {
    private int itemsCount;
    private int gap;

    public InfoItemGridSpacingDecorator(int itemsCount, int gap) {
        this.itemsCount = itemsCount;
        this.gap = gap;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);
        int spanSize = ((GridLayoutManager) parent.getLayoutManager()).getSpanSizeLookup().getSpanSize(position);

        boolean right, bottom;

        if (spanSize == 1) {
            if (position % 2 == 0) {
                right = true;
            } else {
                right = false;
            }
        } else {
            right = false;
        }

        if (position == itemsCount - 1
                || (position == itemsCount - 2 && spanSize == 1)) {
            bottom = false;
        } else {
            bottom = true;
        }

        outRect.right = (right) ? gap : 0;
        outRect.bottom = (bottom) ? gap : 0;

        outRect.left = 0;
        outRect.top = 0;
    }
}
