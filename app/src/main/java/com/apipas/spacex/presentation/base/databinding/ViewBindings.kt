package com.apipas.spacex.presentation.base.databinding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import com.apipas.spacex.R
import com.apipas.spacex.presentation.base.viewmodel.ViewState
import com.bumptech.glide.Glide
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import androidx.annotation.NonNull
import androidx.annotation.StringRes
import com.apipas.spacex.util.extension.toHtml


@BindingAdapter("visibleOrGone")
fun setVisibleOrGone(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("visibleOrInvisible")
fun setVisibleOrInvisible(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("showOnLoading")
fun setShowOnLoading(view: View, viewState: ViewState<*>?) {
    view.visibility = when (viewState) {
        ViewState.Loading -> View.VISIBLE
        else -> View.INVISIBLE
    }
}

@BindingAdapter("showOnError")
fun setShowOnError(view: View, viewState: ViewState<*>?) {
    view.visibility = when (viewState) {
        is ViewState.Error -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("showOnSuccess")
fun setShowOnSuccess(view: View, viewState: ViewState<*>?) {
    when (viewState) {
        is ViewState.Success -> View.VISIBLE
        else -> View.INVISIBLE
    }
}

@BindingAdapter("fetchImage")
fun setImage(view: ImageView, urlImage: String?) {
    Glide
        .with(view.context)
        .load(urlImage)
        .centerInside()
        .placeholder(R.drawable.ic_patch_placeholder)
        .into(view);
}


@BindingAdapter("values")
fun setRangeSlider(slider: RangeSlider, newList: List<Float>) {
    // Important to break potential infinite loops.
    if (slider.values != newList) {
        slider.values = newList
    }
}

@InverseBindingAdapter(attribute = "values")
fun getRangeSlider(slider: RangeSlider): List<Float> {
    return slider.values
}

@BindingAdapter("app:valuesAttrChanged")
fun setListeners(
    slider: RangeSlider,
    attrChange: InverseBindingListener
) {
    val listener = RangeSlider.OnChangeListener { _, _, _ -> attrChange.onChange() }
    slider.addOnChangeListener(listener)
}


@BindingAdapter(value = ["stringTemplate", "dataList"], requireAll = true)
fun setTextAsHtml(textVew: TextView, @StringRes stringRes: Int, dataList: List<Float>) {
    textVew.text = textVew.context.getString(stringRes, dataList).toHtml()
}