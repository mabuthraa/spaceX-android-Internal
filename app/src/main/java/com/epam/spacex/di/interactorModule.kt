package com.epam.spacex.di

import com.epam.spacex.data.feature.companyInfo.domain.interactor.GetCompanyInfoInteractor
import com.epam.spacex.data.feature.launch.domain.interactor.GetLaunchesInteractor
import org.koin.dsl.module

val interactorModule = module {
    single { GetCompanyInfoInteractor(get()) }
    single { GetLaunchesInteractor(get()) }
}