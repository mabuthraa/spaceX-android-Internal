package com.epam.spacex.presentation.home.model

import android.content.Context
import android.os.Parcelable
import com.epam.spacex.R
import com.epam.spacex.util.extension.toDateTimeFormat
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.util.*
import java.util.concurrent.TimeUnit

@Parcelize
data class HomeLaunchItemModel(
    val id: String,
    val failures: Boolean?,
    val dateUtc: Date? = null,
    val success: Boolean? = null,
    val name: String? = null,
    val rocket: Rocket = Rocket(),
    val imageUrl: String? = null,
    val links: Links? = null

) : Parcelable {

    @Parcelize
    data class Rocket(
        val name: String? = null,
        val flickrImg: String? = null
    ) : Parcelable

    @Parcelize
    data class Links(
        val wikipedia: String? = null,
        val youtubeId: String? = null,
        val article: String? = null
    ) : Parcelable

    @IgnoredOnParcel
    val stateImageUrlRes: Int? by lazy {
        when (success) {
            true -> R.drawable.ic_launch_success
            false -> R.drawable.ic_launch_failure
            null -> null
        }
    }

    @IgnoredOnParcel
    val formattedLaunchDateTime: String by lazy { dateUtc?.toDateTimeFormat() ?: "" }

    @IgnoredOnParcel
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

    @IgnoredOnParcel
    val remainingDaysKey: Int by lazy {
        if (remainingDaysAsValue != null && remainingDaysAsValue!! > 0)
            R.string.home_launch_item_days_since
        else
            R.string.home_launch_item_days_from
    }

    fun isClickable(): Boolean =
        links?.wikipedia != null || links?.article != null || links?.youtubeId != null


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
