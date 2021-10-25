package com.apipas.spacex.data.feature.base.data.datasource.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.base.data.datasource.rest.PagerResponseDto
import com.apipas.spacex.data.feature.base.domain.model.PagerEntity
import com.apipas.spacex.data.feature.launch.data.datasource.rest.LaunchResponseDto
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity

class PageDataMapper<T : Any, E : Any> : Mapper<PagerResponseDto<T>, PagerEntity<E>> {
    override fun map(origin: PagerResponseDto<T>) =
        PagerEntity<E>(
            hasNextPage = origin.hasNextPage,
            limit = origin.limit,
            page = origin.page
        )
}