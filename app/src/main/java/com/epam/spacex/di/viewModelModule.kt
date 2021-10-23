package com.epam.spacex.di

import com.epam.spacex.presentation.home.HomeVM
import com.epam.spacex.presentation.main.MainVM
import com.epam.spacex.presentation.notedetail.NoteDetailVm
import com.epam.spacex.presentation.notelist.NoteListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NoteListVM(get()) }
    viewModel { HomeVM(get()) }
    viewModel { NoteDetailVm(get()) }
    viewModel { MainVM() }
}