package com.epam.spacex.presentation.home.model.mapper

import com.epam.spacex.data.common.mapper.Mapper
import com.epam.spacex.data.feature.companyInfo.domain.model.CompanyInfoEntity
import com.epam.spacex.presentation.home.model.HomeCompanyModel

class HomeCompanyInfoVMMapper : Mapper<CompanyInfoEntity, HomeCompanyModel> {
    override fun map(origin: CompanyInfoEntity) =
        HomeCompanyModel(
            companyName = origin.companyName,
            founderName = origin.founderName,
            foundedYear = origin.foundedYear,
            employees = origin.employees,
            launchSites = origin.launchSites,
            valuation = origin.valuation
        )
}