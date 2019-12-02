package com.hito.nikolay.lesson_6_utkin;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HouseCounterItemDecorator extends RecyclerView.ItemDecoration {
    private int itemsCount;
    private int gap;

    public HouseCounterItemDecorator(int gap, int itemsCount) {
        this.gap = gap;
        this.itemsCount = itemsCount;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);

        outRect.right = gap;
        outRect.left = gap;
        outRect.top = gap;

        if (position==itemsCount-1)
            outRect.bottom = gap;
        else
            outRect.bottom = 0;
    }
}
