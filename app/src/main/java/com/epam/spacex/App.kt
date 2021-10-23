package com.epam.spacex

import android.app.Application
import com.epam.spacex.di.remoteDataModule
import com.epam.spacex.di.repositoryModule
import com.epam.spacex.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    companion object {
        lateinit var instance: App private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule, remoteDataModule, repositoryModule))
        }
    }
}