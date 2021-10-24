package com.apipas.spacex.data.feature.companyInfo.data.datasource.rest

import retrofit2.http.GET

interface CompanyInfoApiService {

    @GET("company")
    suspend fun getCompanyInfo(): CompanyInfoDto
}