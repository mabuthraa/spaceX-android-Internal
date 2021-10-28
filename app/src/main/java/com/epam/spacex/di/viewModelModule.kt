package com.epam.spacex.di

import com.epam.spacex.presentation.filter.viewmodel.FilterViewModel
import com.epam.spacex.presentation.home.viewmodel.HomeViewModel
import com.epam.spacex.presentation.main.viewmodel.MainVM
import com.epam.spacex.presentation.media.viewmodel.MediaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainVM() }
    viewModel { HomeViewModel(get(), get()) }
    single { FilterViewModel() }
    viewModel { MediaViewModel() }
}