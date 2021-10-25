package com.apipas.spacex.data.feature.base.domain.model

import com.squareup.moshi.Json

data class PagerEntity<T : Any>(
    @Json(name = "docs")
    val docs: List<T> = emptyList(),
    val hasNextPage: Boolean? = null,
    val limit: Int? = null,
    val page: Int? = null,
    val totalDocs: Int? = null
)