package com.epam.spacex.data.feature.launch.data.datasource.rest

import com.epam.spacex.data.feature.base.data.datasource.rest.PagerResponseDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LaunchDataStore(private val launchApiService: LaunchApiService) {

    fun getLaunches(requestDto: QueryRequestDto): Flow<PagerResponseDto<LaunchResponseDto>> =
        flow { emit(launchApiService.getLaunches(requestDto)) }
}