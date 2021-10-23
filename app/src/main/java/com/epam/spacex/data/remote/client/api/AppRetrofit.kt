package com.epam.spacex.data.remote.client.api

import com.epam.spacex.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class AppRetrofit(val okHttpClient: OkHttpClient) {

    fun getRetrofitBuilder(): Retrofit.Builder {


        return Retrofit.Builder()
            .baseUrl(Constants.DEFAULT_HOST)
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().build()
                )
            )
    }
}