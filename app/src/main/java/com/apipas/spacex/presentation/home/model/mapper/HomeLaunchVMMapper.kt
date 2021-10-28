package com.apipas.spacex.presentation.home.model.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity
import com.apipas.spacex.presentation.home.model.HomeLaunchItemModel

class HomeLaunchVMMapper : Mapper<LaunchEntity, HomeLaunchItemModel> {
    override fun map(origin: LaunchEntity) =
        HomeLaunchItemModel(
            id = origin.id,
            dateUtc = origin.dateUtc,
            success = origin.success,
            name = origin.name,
            rocket = origin.rocket,
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