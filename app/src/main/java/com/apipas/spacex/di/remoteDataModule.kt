package com.apipas.spacex.di

import android.content.Context
import com.apipas.spacex.data.feature.companyInfo.data.datasource.rest.CompanyInfoApiService
import com.apipas.spacex.data.feature.launch.data.datasource.rest.LaunchApiService
import com.apipas.spacex.data.common.network.AppOkHttpClient
import okhttp3.OkHttpClient
import com.apipas.spacex.data.common.network.AppRetrofit
import org.koin.dsl.module
import retrofit2.Retrofit
import kotlin.reflect.KClass

val remoteDataModule = module {
    factory { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }

    //api
    factory { provideApi<CompanyInfoApiService>(get(), CompanyInfoApiService::class) }
    factory { provideApi<LaunchApiService>(get(), LaunchApiService::class) }
}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return AppRetrofit(okHttpClient).getRetrofitBuilder().build()
}

fun provideOkHttpClient(context: Context): OkHttpClient {
    return AppOkHttpClient(
        context
    ).getDefaultOkHttpClientBuilder().build()
}


fun <T> provideApi(retrofit: Retrofit, cls: KClass<*>): T {
    return retrofit.create(cls.java) as T
}