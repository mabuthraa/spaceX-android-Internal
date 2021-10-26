package com.apipas.spacex.data.feature.launch.data.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.launch.data.datasource.rest.LaunchResponseDto
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity

class LaunchDataMapper : Mapper<LaunchResponseDto, LaunchEntity> {
    override fun map(origin: LaunchResponseDto) =
        LaunchEntity(
            id = origin.id!!, //todo add special exception for mapper
            staticFireDateUtc = origin.staticFireDateUtc,
            dateUtc = origin.dateUtc,
            success = origin.success,
            name = origin.name,
            upcoming = origin.upcoming,
            rocket = origin.rocket,
            failures = origin.failures?.map {
                LaunchEntity.FailuresItem(
                    altitude = it.altitude,
                    reason = it.reason,
                    time = it.time
                )
            } ?: emptyList(),
            links = origin.links?.let { linksOrigin ->
                LaunchEntity.Links(
                    patch = linksOrigin.patch?.let { LaunchEntity.Patch(it.small, it.large) },
                    webcast = linksOrigin.webcast,
                    flickr = linksOrigin.flickr?.let { flickerOrigin ->
                        LaunchEntity.Flickr(
                            original = flickerOrigin.original ?: emptyList()
                        )
                    },
                    reddit = linksOrigin.reddit?.let { redditOrigin ->
                        LaunchEntity.Reddit(
                            campaign = redditOrigin.campaign,
                            launch = redditOrigin.launch,
                            media = redditOrigin.media,
                            recovery = redditOrigin.recovery
                        )
                    },
                    wikipedia = linksOrigin.wikipedia,
                    youtubeId = linksOrigin.youtubeId,
                    presskit = linksOrigin.presskit,
                    article = linksOrigin.article
                )
            })
}