package com.apipas.spacex.presentation.filter.model

import com.apipas.spacex.R
import com.apipas.spacex.util.NonNullMutableLiveData
import java.util.*

data class FilterModel(
    var yearRange: NonNullMutableLiveData<List<Float>>,
    val onlyLaunchesModel: NonNullMutableLiveData<Boolean>,
    val sortModel: NonNullMutableLiveData<Int>
) {
    constructor() : this(
        yearRange = NonNullMutableLiveData<List<Float>>(listOf(yearRangeStart, yearRangeEnd)),
        onlyLaunchesModel = NonNullMutableLiveData(true),
        sortModel = NonNullMutableLiveData<@androidx.annotation.IdRes Int>(R.id.filter_sort_desc)
    )

    fun getYearRangeStart() = yearRangeStart
    fun getYearRangeEndMax() = yearRangeEndMax

    companion object {
        private const val yearRangeStart: Float = 2005F
        private val yearRangeEnd: Float = Calendar.getInstance().get(Calendar.YEAR).toFloat()

        //set max to currentYear + 5 dynamically
        private val yearRangeEndMax: Float = yearRangeEnd + 5F
    }
}