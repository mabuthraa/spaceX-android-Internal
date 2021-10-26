package com.apipas.spacex.di

import com.apipas.spacex.presentation.filter.viewmodel.FilterViewModel
import com.apipas.spacex.presentation.home.viewmodel.HomeViewModel
import com.apipas.spacex.presentation.main.viewmodel.MainVM
import com.apipas.spacex.presentation.media.viewmodel.MediaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainVM() }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { FilterViewModel() }
    viewModel { MediaViewModel() }
}