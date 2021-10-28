package com.epam.spacex.data.feature.companyInfo.data.datasource.rest

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CompanyInfoDataStore(private val companyInfoApiService: CompanyInfoApiService) {

    fun getCompanyInfo(): Flow<CompanyInfoResponseDto> = flow {
        emit(companyInfoApiService.getCompanyInfo())
    }
}