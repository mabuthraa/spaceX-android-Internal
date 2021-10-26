package com.apipas.spacex.data.common.network

import com.apipas.spacex.app.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*


class AppRetrofit(private val okHttpClient: OkHttpClient) {

    fun getRetrofitBuilder(): Retrofit.Builder {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe()).build()

        return Retrofit.Builder()
            .baseUrl(Constants.DEFAULT_HOST)
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    moshi
                )
            )
    }
}