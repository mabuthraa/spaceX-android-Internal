package com.apipas.spacex.data.feature.companyInfo.data.datasource.rest

import com.squareup.moshi.Json

data class CompanyInfoResponseDto(

    @Json(name = "summary")
    val summary: String? = null,

    @Json(name = "coo")
    val coo: String? = null,

    @Json(name = "founder")
    val founder: String? = null,

    @Json(name = "founded")
    val founded: Int? = null,

    @Json(name = "vehicles")
    val vehicles: Int? = null,

    @Json(name = "ceo")
    val ceo: String? = null,

    @Json(name = "launch_sites")
    val launchSites: Int? = null,

    @Json(name = "headquarters")
    val headquarters: Headquarters? = null,

    @Json(name = "valuation")
    val valuation: Long? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "links")
    val links: Links? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "employees")
    val employees: Int? = null,

    @Json(name = "test_sites")
    val testSites: Int? = null,

    @Json(name = "cto")
    val cto: String? = null,

    @Json(name = "cto_propulsion")
    val ctoPropulsion: String? = null
) {

    data class Links(

        @Json(name = "website")
        val website: String? = null,

        @Json(name = "twitter")
        val twitter: String? = null,

        @Json(name = "flickr")
        val flickr: String? = null,

        @Json(name = "elon_twitter")
        val elonTwitter: String? = null
    )

    data class Headquarters(

        @Json(name = "address")
        val address: String? = null,

        @Json(name = "city")
        val city: String? = null,

        @Json(name = "state")
        val state: String? = null
    )
}