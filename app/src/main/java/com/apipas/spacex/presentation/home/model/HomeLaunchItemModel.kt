package com.apipas.spacex.presentation.home.model

import android.content.Context
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apipas.spacex.R
import com.apipas.spacex.util.extension.toDateTimeFormat
import kotlinx.parcelize.Parcelize
import java.util.*
import java.util.concurrent.TimeUnit

@Parcelize
data class HomeLaunchItemModel(
    val id: String,
    val staticFireDateUtc: Date? = null,//to be removed
    val failures: Boolean?,
    val dateUtc: Date? = null,
    val success: Boolean? = null,
    val name: String? = null,
    val upcoming: Boolean? = null,
    val rocket: String? = null,
    val imageUrl: String? = null
) : Parcelable {

    val stateImageUrlRes: Int? by lazy {
        when (success) {
            true -> R.drawable.ic_launch_success
            false -> R.drawable.ic_launch_failure
            null -> null
        }
    }

    val formattedLaunchDateTime: String by lazy { dateUtc?.toDateTimeFormat() ?: "" }

    private val remainingDaysAsValue: Int? by lazy {
        if (dateUtc != null) {
            val currentTime = Calendar.getInstance().timeInMillis
            val launchingTimeCal = Calendar.getInstance()
            launchingTimeCal.time = dateUtc
            val launchingTime = launchingTimeCal.timeInMillis
            val delta = currentTime - launchingTime
            TimeUnit.MILLISECONDS.toDays(delta).toInt()
        } else {
            null
        }
    }

    val remainingDaysKey: Int by lazy {
        if (remainingDaysAsValue != null && remainingDaysAsValue!! > 0)
            R.string.home_launch_item_days_since
        else
            R.string.home_launch_item_days_from
    }

    fun remainingDaysAsString(context: Context): String {
        return when (val value = remainingDaysAsValue) {
            0 -> context.getString(R.string.home_launch_item_today)
            null -> ""
            else -> if (value > 0)
                context.getString(R.string.home_launch_item_since, value)
            else
                context.getString(R.string.home_launch_item_from, value)
        }
    }
}

