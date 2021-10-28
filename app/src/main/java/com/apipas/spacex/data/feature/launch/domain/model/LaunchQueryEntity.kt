package com.apipas.spacex.data.feature.launch.domain.model

import java.util.*

data class LaunchQueryEntity(
    val nextPage: Int? = 1,
    val hasNextPage: Boolean = true,
    val filterEntity: FilterEntity
) {
    val limit = 20

    data class FilterEntity(
        val yearStart: Date,
        val yearEndInclusive: Date,
        val onlySuccessfulLaunch: Boolean,
        val sort: Sort
    )

    enum class Sort {
        LAUNCH_TIME_ASC,
        LAUNCH_TIME_DESC
    }
}