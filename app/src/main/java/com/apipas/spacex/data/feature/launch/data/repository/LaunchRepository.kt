package com.apipas.spacex.data.feature.launch.data.repository

import com.apipas.spacex.data.feature.launch.data.datasource.rest.LaunchDataStore
import com.apipas.spacex.data.feature.launch.data.mapper.LaunchDataMapper
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface LaunchRepository {
    fun getLaunches(): Flow<LaunchEntity>
    fun getLaunchByUd(id: String): Flow<LaunchEntity>
}

class LaunchRepositoryImpl(
    private val dataStore: LaunchDataStore
) : LaunchRepository {

    private val dataMapper by lazy { LaunchDataMapper() }

    override fun getLaunches(): Flow<LaunchEntity> =
        dataStore.getLaunches().map {
            dataMapper.map(it)
        }

    override fun getLaunchByUd(id: String): Flow<LaunchEntity> =
        dataStore.getLaunchById(id).map {
            dataMapper.map(it)
        }
}
