package com.apipas.spacex.data.feature.launch.data.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.launch.data.datasource.rest.LaunchResponseDto
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity

class LaunchDataMapper : Mapper<LaunchResponseDto, LaunchEntity> {
    override fun map(origin: LaunchResponseDto) =
        LaunchEntity(
            id = origin.id!!, //todo add special exception for mapper
            dateUtc = origin.dateUtc,
            success = origin.success,
            name = origin.name,
            rocket = origin.rocket?.let { rocket ->
                LaunchEntity.Rocket(
                    name = rocket.name,
                    flickrImgs = rocket.flickrImages
                )
            },
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
                    wikipedia = linksOrigin.wikipedia,
                    youtubeId = linksOrigin.youtubeId,
                    article = linksOrigin.article
                )
            })
}