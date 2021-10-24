package com.apipas.spacex.presentation.base.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import com.apipas.spacex.presentation.base.viewmodel.ViewState


@BindingAdapter("visibleOrGone")
fun setVisibleOrGone(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("visibleOrInvisible")
fun setVisibleOrInvisible(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("showOnLoading")
fun setShowOnLoading(view: View, viewState: ViewState<*>) {
    view.visibility = when (viewState) {
        ViewState.Loading -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("showOnError")
fun setShowOnError(view: View, viewState: ViewState<*>) {
    view.visibility = when (viewState) {
        is ViewState.Error -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("showOnSuccess")
fun setShowOnSuccess(view: View, viewState: ViewState<*>) {
    view.visibility = when (viewState) {
        is ViewState.Success -> View.VISIBLE
        else -> View.INVISIBLE
    }
}