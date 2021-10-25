package com.apipas.spacex.data.feature.launch.data.repository

import com.apipas.spacex.data.feature.base.data.datasource.mapper.PageDataMapper
import com.apipas.spacex.data.feature.base.data.datasource.rest.PagerResponseDto
import com.apipas.spacex.data.feature.base.domain.model.PagerEntity
import com.apipas.spacex.data.feature.launch.data.datasource.rest.LaunchDataStore
import com.apipas.spacex.data.feature.launch.data.datasource.rest.LaunchResponseDto
import com.apipas.spacex.data.feature.launch.data.mapper.LaunchDataMapper
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity
import com.apipas.spacex.data.feature.launch.domain.model.LaunchQueryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface LaunchRepository {
    fun getLaunches(launchQueryEntity: LaunchQueryEntity): Flow<PagerEntity<LaunchEntity>>
}

class LaunchRepositoryImpl(
    private val dataStore: LaunchDataStore
) : LaunchRepository {

    private val dataMapper by lazy { LaunchDataMapper() }

    private val pageDataMapper by lazy { PageDataMapper<LaunchResponseDto, LaunchEntity>() }

    override fun getLaunches(launchQueryEntity: LaunchQueryEntity): Flow<PagerEntity<LaunchEntity>> =
        dataStore.getLaunches(launchQueryEntity).map {
            pageDataMapper.map(it).copy(docs = dataMapper.map(it.docs ?: emptyList()))
        }
}
