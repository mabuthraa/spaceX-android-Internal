package com.apipas.spacex.presentation.home.model.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.companyInfo.domain.model.CompanyInfoEntity
import com.apipas.spacex.presentation.home.model.HomeCompanyModel

class HomeCompanyInfoVMMapper : Mapper<CompanyInfoEntity, HomeCompanyModel> {
    override fun map(origin: CompanyInfoEntity) =
        HomeCompanyModel(
            companyName = origin.companyName,
            founderName = origin.founderName,
            employees = origin.employees,
            launchSites = origin.launchSites
        )
}