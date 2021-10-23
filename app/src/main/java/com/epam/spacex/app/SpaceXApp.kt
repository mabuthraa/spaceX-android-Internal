package com.epam.spacex.app

import android.app.Application
import com.epam.spacex.di.remoteDataModule
import com.epam.spacex.di.repositoryModule
import com.epam.spacex.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SpaceXApp : Application() {
    //todo to be removed and use DI to retrieve AppContext
    companion object {
        lateinit var instance: SpaceXApp private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@SpaceXApp)
            modules(listOf(viewModelModule, remoteDataModule, repositoryModule))
        }
    }
}