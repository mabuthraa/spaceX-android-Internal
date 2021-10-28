package com.epam.spacex.data.feature.launch.data.datasource.rest

import com.epam.spacex.data.feature.base.data.datasource.rest.PagerResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface LaunchApiService {

    @POST("launches/query")
    suspend fun getLaunches(@Body body: QueryRequestDto = QueryRequestDto()): PagerResponseDto<LaunchResponseDto>
}