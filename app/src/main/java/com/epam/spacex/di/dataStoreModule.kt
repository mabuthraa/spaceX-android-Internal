package com.epam.spacex.di

import com.epam.spacex.data.feature.companyInfo.data.datasource.rest.CompanyInfoDataStore
import com.epam.spacex.data.feature.launch.data.datasource.rest.LaunchDataStore
import org.koin.dsl.module

val dataStoreMode = module {
    single { CompanyInfoDataStore(get()) }
    single { LaunchDataStore(get()) }
}