package com.epam.spacex.data.feature.companyInfo.domain.model

data class CompanyInfoEntity(
    val companyName: String?,
    val founderName: String?,
    val foundedYear: Int?,
    val employees: Int?,
    val launchSites: Int?,
    val valuation: Long?
)