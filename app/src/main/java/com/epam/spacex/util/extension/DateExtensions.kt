package com.epam.spacex.util.extension

import java.text.SimpleDateFormat
import java.util.*


const val DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd @ hh:mm"
const val ISO8601_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

fun Date.toDateTimeFormat(): String {
    val formatter = SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT, Locale.getDefault())
    return formatter.format(this)
}

fun Date.toISO8601Format(): String {
    val formatter = SimpleDateFormat(ISO8601_DATE_TIME_FORMAT, Locale.getDefault())
    return formatter.format(this)
}
