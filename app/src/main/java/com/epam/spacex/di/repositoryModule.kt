package com.epam.spacex.di

import com.epam.spacex.data.repository.NoteRepository
import com.epam.spacex.data.repository.NoteRepositoryImp
import org.koin.dsl.module


val repositoryModule = module {
    single<NoteRepository> { NoteRepositoryImp(get()) }
}