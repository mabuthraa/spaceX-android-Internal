package com.apipas.spacex.data.feature.launch.data.datasource.rest

import com.apipas.spacex.data.feature.base.data.datasource.rest.PagerResponseDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.getScopeId

class LaunchDataStore(private val launchApiService: LaunchApiService) {

    fun getLaunches(): Flow<PagerResponseDto<LaunchResponseDto>> = flow {
        emit(launchApiService.getLaunches())
    }
}