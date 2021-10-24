package com.apipas.spacex.presentation.home.model.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity
import com.apipas.spacex.presentation.home.model.HomeLaunchItem

class HomeLaunchVMMapper : Mapper<LaunchEntity, HomeLaunchItem> {
    override fun map(origin: LaunchEntity) =
        HomeLaunchItem(
            id = origin.id,
            staticFireDateUtc = origin.staticFireDateUtc,
            dateUtc = origin.dateUtc,
            success = origin.success,
            name = origin.name,
            upcoming = origin.upcoming,
            rocket = origin.rocket,
            failures = origin.failures.isNotEmpty(),
            imageUrl = origin.links?.patch?.small
        )
}