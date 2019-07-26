package com.example.shortybin.oslearn.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by shortybin
 * on 2019-07-26
 */
class HttpClient {
    companion object {
        val baseUrl = "https://www.wanandroid.com"

        fun getHttpClient(): WanAndroidApi {
            val builder = OkHttpClient.Builder()
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val build = builder.addInterceptor(httpLoggingInterceptor).build()

            val retrofit =
                Retrofit.Builder().client(build).baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                    .build()

            val wanAndroidApi = retrofit.create(WanAndroidApi::class.java)
            return wanAndroidApi
        }
    }


}