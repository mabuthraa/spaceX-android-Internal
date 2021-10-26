package com.apipas.spacex.di

import com.apipas.spacex.presentation.home.viewmodel.HomeViewModel
import com.apipas.spacex.presentation.main.MainVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { MainVM() }
}