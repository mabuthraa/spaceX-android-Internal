package com.epam.spacex.presentation.home.model.mapper

import com.epam.spacex.data.common.mapper.Mapper
import com.epam.spacex.data.feature.launch.domain.model.LaunchEntity
import com.epam.spacex.presentation.home.model.HomeLaunchItemModel

class HomeLaunchVMMapper : Mapper<LaunchEntity, HomeLaunchItemModel> {
    override fun map(origin: LaunchEntity) =
        HomeLaunchItemModel(
            id = origin.id,
            dateUtc = origin.dateUtc,
            success = origin.success,
            name = origin.name,
            rocket = HomeLaunchItemModel.Rocket(
                origin.rocket?.name,
                origin.rocket?.flickrImgs?.random()
            ),
            failures = origin.failures.isNotEmpty(),
            imageUrl = origin.links?.patch?.small,
            links = origin.links?.let {
                HomeLaunchItemModel.Links(
                    wikipedia = origin.links.wikipedia,
                    youtubeId = origin.links.youtubeId,
                    article = origin.links.article
                )
            }
        )
}