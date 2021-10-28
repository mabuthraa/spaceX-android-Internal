package com.epam.spacex.data.common.network

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class AppOkHttpClient(
    val context: Context
) {

    fun getDefaultOkHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
            .addInterceptor(ChuckInterceptor(context))
    }
}
