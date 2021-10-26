package com.apipas.spacex.di


import com.apipas.spacex.data.feature.companyInfo.data.repository.CompanyInfoRepository
import com.apipas.spacex.data.feature.companyInfo.data.repository.CompanyInfoRepositoryImpl
import com.apipas.spacex.data.feature.launch.data.repository.LaunchRepository
import com.apipas.spacex.data.feature.launch.data.repository.LaunchRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<CompanyInfoRepository> { CompanyInfoRepositoryImpl(get()) }
    single<LaunchRepository> { LaunchRepositoryImpl(get()) }
}