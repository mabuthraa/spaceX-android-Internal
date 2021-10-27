package com.apipas.spacex.presentation.filter.model

import com.apipas.spacex.R
import com.apipas.spacex.util.NonNullMutableLiveData
import java.util.*

class FilterYearRangeModel {
    private val yearRangeEnd: Float = Calendar.getInstance().get(Calendar.YEAR).toFloat()

    val yearRangeStart: Float = 2005F
    val yearRangeEndMax: Float = yearRangeEnd + 5F //set max to currentYear + 5 dynamically

    var yearRange = NonNullMutableLiveData<List<Float>>(listOf(2005f, 2025f))
    val onlyLaunchesModel = NonNullMutableLiveData(true)
    val sortModel = NonNullMutableLiveData<@androidx.annotation.IdRes Int>(R.id.filter_sort_desc)

}