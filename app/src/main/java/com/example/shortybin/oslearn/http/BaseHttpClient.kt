package com.example.shortybin.oslearn.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by shortybin
 * on 2019-07-26
 */
abstract class BaseHttpClient {

    private val okHttpClient: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(httpLoggingInterceptor)

            addHttpSetting(builder)

            return builder.build()
        }

    protected abstract fun addHttpSetting(builder: OkHttpClient.Builder)

    protected fun <T> getApiService(api: Class<T>, baseurl: String): T {
        return Retrofit.Builder().baseUrl(baseurl).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build().create(api)
    }
}