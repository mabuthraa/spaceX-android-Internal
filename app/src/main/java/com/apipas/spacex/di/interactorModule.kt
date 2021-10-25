package com.apipas.spacex.di

import com.apipas.spacex.data.feature.companyInfo.domain.interactor.GetCompanyInfoInteractor
import com.apipas.spacex.data.feature.launch.domain.interactor.GetLaunchByIdInteractor
import com.apipas.spacex.data.feature.launch.domain.interactor.GetLaunchesInteractor
import org.koin.dsl.module

val interactorModule = module {
    single { GetCompanyInfoInteractor(get()) }
    single { GetLaunchesInteractor(get()) }
    single { GetLaunchByIdInteractor(get()) }
}