package com.apipas.spacex.data.feature.base.data.datasource.rest

import com.squareup.moshi.Json

data class PagerResponseDto<T : Any>(

    @Json(name = "hasPrevPage")
    val hasPrevPage: Boolean? = null,

    @Json(name = "docs")
    val docs: List<T>? = null,

    @Json(name = "hasNextPage")
    val hasNextPage: Boolean? = null,

    @Json(name = "pagingCounter")
    val pagingCounter: Int? = null,

    @Json(name = "nextPage")
    val nextPage: Int? = null,

    @Json(name = "limit")
    val limit: Int? = null,

    @Json(name = "totalPages")
    val totalPages: Int? = null,

    @Json(name = "prevPage")
    val prevPage: Int? = null,

    @Json(name = "page")
    val page: Int? = null,

    @Json(name = "totalDocs")
    val totalDocs: Int? = null
)
