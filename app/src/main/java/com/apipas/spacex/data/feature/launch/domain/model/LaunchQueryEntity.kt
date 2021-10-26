package com.apipas.spacex.data.feature.launch.domain.model

data class LaunchQueryEntity(val nextPage: Int? = 1, val hasNextPage: Boolean = true) {
    val limit = 20
}