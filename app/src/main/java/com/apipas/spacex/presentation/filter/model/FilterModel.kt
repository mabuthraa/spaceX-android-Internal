package com.apipas.spacex.presentation.filter.model

import android.content.Context
import android.text.Spanned
import com.apipas.spacex.R
import com.apipas.spacex.util.NonNullMutableLiveData
import com.apipas.spacex.util.extension.toHtml

data class FilterModel(var yearRange: NonNullMutableLiveData<List<Float>>) {
    fun formatRangeSliderLabel(context: Context): Spanned {
        return context.getString(
            R.string.filter_year_bar_label,
            yearRange.value[0],
            yearRange.value[1]
        ).toHtml()
    }
}