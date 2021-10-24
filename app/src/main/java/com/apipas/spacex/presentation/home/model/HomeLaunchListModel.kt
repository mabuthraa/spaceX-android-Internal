package com.apipas.spacex.presentation.home.model

import androidx.annotation.DrawableRes
import com.apipas.spacex.R

data class HomeLaunchItem(
    val id: String,
    val staticFireDateUtc: String? = null,
    val failures: Boolean?,
    val dateUtc: String? = null,
    val success: Boolean? = null,
    val name: String? = null,
    val upcoming: Boolean? = null,
    val rocket: String? = null,
    val imageUrl: String? = null
) {
    @DrawableRes
    val stateImageUrlRes: Int? = when (failures) {
        false -> R.drawable.ic_launch_success
        true -> R.drawable.ic_launch_failure
        null -> null
    }

}

