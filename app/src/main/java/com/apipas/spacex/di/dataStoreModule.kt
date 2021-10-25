package com.apipas.spacex.di

import com.apipas.spacex.data.feature.companyInfo.data.datasource.rest.CompanyInfoDataStore
import com.apipas.spacex.data.feature.launch.data.datasource.rest.LaunchDataStore
import org.koin.dsl.module

val dataStoreMode = module {
    single { CompanyInfoDataStore(get()) }
    single { LaunchDataStore(get()) }
}