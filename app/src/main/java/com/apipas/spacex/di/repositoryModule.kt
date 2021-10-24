package com.apipas.spacex.di

import com.apipas.spacex.data.feature.companyInfo.domain.repository.CompanyInfoRepository
import com.apipas.spacex.data.feature.companyInfo.domain.repository.CompanyInfoRepositoryImpl
import com.apipas.spacex.data.repository.NoteRepository
import com.apipas.spacex.data.repository.NoteRepositoryImp
import org.koin.dsl.module


val repositoryModule = module {
    single<NoteRepository> { NoteRepositoryImp(get()) }
    single<CompanyInfoRepository> { CompanyInfoRepositoryImpl(get()) }
}