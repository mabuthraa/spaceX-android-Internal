package com.apipas.spacex.presentation.home.viewmodel.state

import com.apipas.spacex.presentation.home.model.HomeCompanyModel

sealed class HomeCompanyInfoVS {
    class AddCompanyInfo(val homeCompanyModel: HomeCompanyModel) : HomeCompanyInfoVS()
    class Error(val message: String?) : HomeCompanyInfoVS()
    class ShowLoader(val showLoader: Boolean) : HomeCompanyInfoVS()
}