package com.apipas.spacex.data.feature.launch.data.datasource.rest

import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchApiService {

    @GET("launches")
    suspend fun getLaunches(): List<LaunchDto>

    @GET("launches/{id}")
    suspend fun getLaunchById(@Path("id") id:String): LaunchDto
}