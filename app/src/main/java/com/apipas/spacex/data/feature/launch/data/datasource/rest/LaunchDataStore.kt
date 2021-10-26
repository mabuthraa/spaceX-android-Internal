package com.apipas.spacex.data.feature.launch.data.datasource.rest

import com.apipas.spacex.data.feature.base.data.datasource.rest.PagerResponseDto
import com.apipas.spacex.data.feature.launch.domain.model.LaunchQueryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.getScopeId

class LaunchDataStore(private val launchApiService: LaunchApiService) {

    fun getLaunches(launchQueryEntity: LaunchQueryEntity): Flow<PagerResponseDto<LaunchResponseDto>> =
        flow {
            val request = LaunchRequestDto(
                options = LaunchRequestDto.Options(
                    limit = launchQueryEntity.limit,
                    page = launchQueryEntity.nextPage
                )
            )
            emit(launchApiService.getLaunches(request))
        }
}