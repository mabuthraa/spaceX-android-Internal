package com.apipas.spacex.util.extension

import java.text.SimpleDateFormat
import java.util.*


const val DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd @ hh:mm"

fun Date.toDateTimeFormat(): String {
    val formatter = SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT, Locale.getDefault())
    return formatter.format(this)
}