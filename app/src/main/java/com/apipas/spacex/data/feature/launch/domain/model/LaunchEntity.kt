package com.apipas.spacex.data.feature.launch.domain.model

import java.util.*

data class LaunchEntity(
    val id: String,
    val staticFireDateUtc: Date? = null,
    val failures: List<FailuresItem> = emptyList(),
    val dateUtc: Date? = null,
    val success: Boolean? = null,
    val name: String? = null,
    val upcoming: Boolean? = null,
    val rocket: String? = null,
    val links: Links? = null,
) {

    data class FailuresItem(
        val altitude: Int? = null,
        val reason: String? = null,
        val time: Int? = null
    )

    data class Links(
        val patch: Patch? = null,
        val webcast: String? = null,
        val flickr: Flickr? = null,
        val reddit: Reddit? = null,
        val wikipedia: String? = null,
        val youtubeId: String? = null,
        val presskit: String? = null,
        val article: String? = null
    )

    data class Patch(
        val small: String? = null,
        val large: String? = null
    )

    data class Flickr(
        val original: List<String> = emptyList()
    )

    data class Reddit(
        val campaign: String? = null,
        val launch: String? = null,
        val media: String? = null,
        val recovery: String? = null
    )
}