package com.hito.nikolay.lesson_8_utkin

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class NoteGridSpacingDecorator(val gap: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val isLeft: Boolean

        isLeft = position % 2 == 0
        outRect.right = if (isLeft) gap / 2 else gap
        outRect.left = if (isLeft) gap else gap / 2

        outRect.bottom = gap / 2
        outRect.top = gap / 2
    }
}