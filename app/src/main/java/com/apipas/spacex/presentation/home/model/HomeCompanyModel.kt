package com.apipas.spacex.presentation.home.model

import android.content.Context
import android.text.Spanned
import com.apipas.spacex.R
import com.apipas.spacex.util.CurrencyFormat
import com.apipas.spacex.util.extension.toHtml

data class HomeCompanyModel(
    val companyName: String?,
    val founderName: String?,
    val foundedYear: Int?,
    val employees: Int?,
    val launchSites: Int?,
    val valuation: Long?
) {

    fun getCompanyInfoParagraph(context: Context): Spanned {
        return context.getString(
            R.string.home_company,
            this.companyName,
            this.founderName,
            this.foundedYear,
            this.employees,
            this.launchSites,
            CurrencyFormat.formatToInteger(this.valuation)
        ).toHtml()
    }
}
