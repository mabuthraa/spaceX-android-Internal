package com.epam.spacex.util

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt


object ColorUtil {

    @ColorInt
    fun getColorFromTheme(context: Context, @AttrRes value: Int, @ColorInt defaultValue: Int): Int {
        return try {
            val typedValue = TypedValue()
            context.theme.resolveAttribute(value, typedValue, true)
            typedValue.data
        }catch (e:Exception){
            Log.e("Error on loading color from theme", e)
            defaultValue
        }
    }
}