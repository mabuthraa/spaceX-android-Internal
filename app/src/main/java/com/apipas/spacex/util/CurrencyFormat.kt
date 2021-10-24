package com.apipas.spacex.util


import java.text.NumberFormat

object CurrencyFormat {

    fun formatToInteger(value: Number?): String? {
        val format: NumberFormat = NumberFormat.getIntegerInstance()
        format.maximumFractionDigits = 0
        return value?.let { format.format(it) }
    }
}