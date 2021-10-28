package com.epam.spacex.data.feature.companyInfo.data.datasource.rest

import retrofit2.http.GET

interface CompanyInfoApiService {

    @GET("company")
    suspend fun getCompanyInfo(): CompanyInfoResponseDto
}