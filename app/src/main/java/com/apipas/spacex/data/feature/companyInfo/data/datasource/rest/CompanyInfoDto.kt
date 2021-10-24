package com.apipas.spacex.data.feature.companyInfo.data.datasource.rest

import com.squareup.moshi.Json

data class CompanyInfoDto(
    val summary: String? = null,
    val coo: String? = null,
    val founder: String? = null,
    val founded: Int? = null,
    val vehicles: Int? = null,
    val ceo: String? = null,
    @field:Json(name = "launch_sites")
    val launchSites: Int? = null,
    val headquarters: Headquarters? = null,
    val valuation: Long? = null,
    val name: String? = null,
    val links: Links? = null,
    val id: String? = null,
    val employees: Int? = null,
    val testSites: Int? = null,
    val cto: String? = null,
    val ctoPropulsion: String? = null
) {
    data class Links(
        val website: String? = null,
        val twitter: String? = null,
        val flickr: String? = null,
        val elonTwitter: String? = null
    )

    data class Headquarters(
        val address: String? = null,
        val city: String? = null,
        val state: String? = null
    )
}