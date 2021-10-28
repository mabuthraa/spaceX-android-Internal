package com.epam.spacex.di


import com.epam.spacex.data.feature.companyInfo.data.repository.CompanyInfoRepository
import com.epam.spacex.data.feature.companyInfo.data.repository.CompanyInfoRepositoryImpl
import com.epam.spacex.data.feature.launch.data.repository.LaunchRepository
import com.epam.spacex.data.feature.launch.data.repository.LaunchRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<CompanyInfoRepository> { CompanyInfoRepositoryImpl(get()) }
    single<LaunchRepository> { LaunchRepositoryImpl(get()) }
}