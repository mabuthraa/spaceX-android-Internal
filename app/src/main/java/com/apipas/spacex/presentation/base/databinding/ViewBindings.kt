package com.apipas.spacex.presentation.base.databinding

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("visibleOrGone")
fun setVisibleOrGone(view: View, visible: Boolean) {
   view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("visibleOrInvisible")
fun setVisibleOrInvisible(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
}