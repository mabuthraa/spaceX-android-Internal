package com.epam.spacex.data.feature.base.domain.model

import com.squareup.moshi.Json

data class PagerEntity<T : Any>(
    @Json(name = "docs")
    val docs: List<T> = emptyList(),
    val hasNextPage: Boolean = false,
    val limit: Int? = null,
    val page: Int? = null,
    val totalDocs: Int? = null,
    val nextPage: Int? = null,
    val totalDoc: Int = 0
)