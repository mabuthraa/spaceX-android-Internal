package com.apipas.spacex.presentation.base.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apipas.spacex.presentation.base.viewmodel.BaseViewModel
import com.apipas.spacex.presentation.base.adapter.SimpleRecyclerAdapter
import com.apipas.spacex.presentation.base.viewmodel.ViewState
import android.widget.Toast
import androidx.annotation.DimenRes
import androidx.core.view.NestedScrollingChild
import androidx.core.widget.NestedScrollView
import com.apipas.spacex.R


@BindingAdapter(value = ["viewModel", "items", "layoutId"])
fun <T> bindItems(
    view: RecyclerView,
    vm: BaseViewModel?,
    items: ObservableArrayList<T>,
    layoutId: Int
) {
    if (view.adapter == null) {
        if (view.layoutManager == null) {
            view.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
            view.adapter = SimpleRecyclerAdapter(items, vm, layoutId)
        } else {
            (view.adapter as SimpleRecyclerAdapter<T>).setItems(items)
        }
    }
}

@BindingAdapter("onLoadMore")
fun setOnLoadMore(
    nsv: NestedScrollView,
    onLoadMore: () -> Unit
) {
    var currentHeight = 0
    val thresholdInPixel =
        nsv.context.resources.getDimensionPixelSize(R.dimen.threshold_scroll_view)
    nsv.setOnScrollChangeListener(
        NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            val totalHeight = nsv.getChildAt(0).height;
            if (currentHeight == totalHeight) return@OnScrollChangeListener
            if (scrollY > oldScrollY) {
                if (totalHeight != 0) {
                    val currentCursorHeight = scrollY.toFloat() + nsv.height
                    val delta = totalHeight.toDouble() - currentCursorHeight
                    if (delta < thresholdInPixel) {
                        onLoadMore.invoke()
                        currentHeight = totalHeight
                    }
                }
            }
        })
}