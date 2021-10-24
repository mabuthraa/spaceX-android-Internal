package com.apipas.spacex.data.feature.companyInfo.data.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.companyInfo.data.datasource.rest.CompanyInfoDto
import com.apipas.spacex.data.feature.companyInfo.domain.model.CompanyInfoEntity

class CompanyInfoDataMapper : Mapper<CompanyInfoDto, CompanyInfoEntity> {
    override fun map(origin: CompanyInfoDto) =
        CompanyInfoEntity(
            companyName = origin.name,
            founderName = origin.founder,
            employees = origin.employees,
            launchSites = origin.launchSites
        )
}