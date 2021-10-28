package com.epam.spacex.data.feature.companyInfo.data.repository

import com.epam.spacex.data.feature.companyInfo.data.datasource.rest.CompanyInfoDataStore
import com.epam.spacex.data.feature.companyInfo.data.mapper.CompanyInfoDataMapper
import com.epam.spacex.data.feature.companyInfo.domain.model.CompanyInfoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface CompanyInfoRepository {
    fun getCompanyInfo(): Flow<CompanyInfoEntity>
}

class CompanyInfoRepositoryImpl(
    private val dataStore: CompanyInfoDataStore
) : CompanyInfoRepository {

    private val dataMapper by lazy { CompanyInfoDataMapper() }

    override fun getCompanyInfo(): Flow<CompanyInfoEntity> =
        dataStore.getCompanyInfo().map {
            dataMapper.map(it)
        }
}
