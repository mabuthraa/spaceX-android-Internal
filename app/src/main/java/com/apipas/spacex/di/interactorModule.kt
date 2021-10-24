package com.apipas.spacex.di

import com.apipas.spacex.data.feature.companyInfo.domain.interactor.GetCompanyInfoInteractor
import org.koin.dsl.module

val interactorModule = module {
    single { GetCompanyInfoInteractor(get()) }
}