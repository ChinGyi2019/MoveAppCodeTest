package com.chingyi.testproject.helper.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber


class HorizontalContentItemDecoration(private val startOffset : Int
, private val itemOffset : Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            Timber.w(state.itemCount.toString())
            if (parent.getChildAdapterPosition(view) == 0) {
                left = startOffset
                right = itemOffset

            }else if (state.itemCount - 1 == parent.getChildAdapterPosition(view)){
                right = startOffset
                left = itemOffset

            }else{
                right = itemOffset
                left = itemOffset
                //top = itemOffset
               // bottom = itemOffset
            }

        }
    }

}