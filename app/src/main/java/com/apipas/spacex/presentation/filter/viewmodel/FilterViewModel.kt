package com.apipas.spacex.presentation.filter.viewmodel

import com.apipas.spacex.presentation.base.viewmodel.BaseViewModel
import com.apipas.spacex.util.NonNullMutableLiveData
import java.util.*

class FilterViewModel() : BaseViewModel() {

    var yearRange = NonNullMutableLiveData<List<Float>>(
        listOf(
            yearRangeStart,
            yearRangeEnd
        )
    )

    companion object {
        val yearRangeStart: Float = 2005F

        //set max to currentYear + 5 dynamically
        val yearRangeEnd: Float = Calendar.getInstance().get(Calendar.YEAR).toFloat()
        val yearRangeEndMax: Float = yearRangeEnd + 5F
    }
}