package com.apipas.spacex.data.feature.launch.data.datasource.rest

import com.squareup.moshi.Json

data class LaunchRequestDto(

    @Json(name = "query")
    val query: Query? = null,

    @Json(name = "options")
    val options: Options? = null
) {

    data class Query(
        val any: Any? = null
    )

    data class Options(

        @Json(name = "limit")
        val limit: Int? = null,

        @Json(name = "page")
        val page: Int? = null
    )
}
