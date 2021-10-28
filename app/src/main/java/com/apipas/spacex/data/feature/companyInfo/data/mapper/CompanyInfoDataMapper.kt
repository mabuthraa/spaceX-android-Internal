package com.apipas.spacex.data.feature.companyInfo.data.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.companyInfo.data.datasource.rest.CompanyInfoResponseDto
import com.apipas.spacex.data.feature.companyInfo.domain.model.CompanyInfoEntity

class CompanyInfoDataMapper : Mapper<CompanyInfoResponseDto, CompanyInfoEntity> {
    override fun map(origin: CompanyInfoResponseDto) =
        CompanyInfoEntity(
            companyName = origin.name,
            founderName = origin.founder,
            foundedYear = origin.founded,
            employees = origin.employees,
            launchSites = origin.launchSites,
            valuation = origin.valuation
        )
}