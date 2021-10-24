package com.apipas.spacex.di

import com.apipas.spacex.presentation.home.viewmodel.HomeViewModel
import com.apipas.spacex.presentation.main.MainVM
import com.apipas.spacex.presentation.notedetail.NoteDetailVm
import com.apipas.spacex.presentation.notelist.NoteListVM
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NoteListVM(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { NoteDetailVm(get()) }
    viewModel { MainVM() }
}