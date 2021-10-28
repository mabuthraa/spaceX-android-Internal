package com.apipas.spacex.data.feature.launch.data.datasource.rest

import com.squareup.moshi.Json

data class LaunchRequestDto(

    @Json(name = "query")
    val query: Map<String, Any>? = null,

    @Json(name = "options")
    val options: Options? = null
) {
    data class Options(

        @Json(name = "limit")
        val limit: Int? = null,

        @Json(name = "page")
        val page: Int? = null,

        @Json(name = "sort")
        val sort: Map<String, String>? = null
    )
}
