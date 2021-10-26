package com.apipas.spacex.data.feature.launch.data.datasource.rest

import com.apipas.spacex.data.feature.base.data.datasource.rest.PagerResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LaunchApiService {

    @POST("launches/query")
    suspend fun getLaunches(@Body body: LaunchRequestDto = LaunchRequestDto()): PagerResponseDto<LaunchResponseDto>
}