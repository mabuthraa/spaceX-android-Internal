package com.epam.spacex.data.feature.base.data.datasource.mapper

import com.epam.spacex.data.common.mapper.Mapper
import com.epam.spacex.data.feature.base.data.datasource.rest.PagerResponseDto
import com.epam.spacex.data.feature.base.domain.model.PagerEntity

class PageDataMapper<T : Any, E : Any> : Mapper<PagerResponseDto<T>, PagerEntity<E>> {
    override fun map(origin: PagerResponseDto<T>) =
        PagerEntity<E>(
            hasNextPage = origin.hasNextPage ?: false,
            limit = origin.limit,
            page = origin.page,
            nextPage = origin.nextPage,
            totalDoc = origin.totalDocs ?: 0
        )
}