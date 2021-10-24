package com.apipas.spacex.di

import com.apipas.spacex.data.feature.companyInfo.data.datasource.rest.CompanyInfoDataStore
import org.koin.dsl.module

val dataStoreMode = module {
    single { CompanyInfoDataStore(get()) }
}