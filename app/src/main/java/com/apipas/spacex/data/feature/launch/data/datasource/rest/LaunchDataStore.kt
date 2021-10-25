package com.apipas.spacex.data.feature.launch.data.datasource.rest

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path

class LaunchDataStore(private val launchApiService: LaunchApiService) {

    fun getLaunches(): Flow<LaunchDto> = flow {
        launchApiService.getLaunches().forEach {
            emit(it)
        }
    }

    fun getLaunchById(id: String): Flow<LaunchDto> = flow {
        emit(launchApiService.getLaunchById(id))
    }
}