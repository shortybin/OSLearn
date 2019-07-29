package com.example.shortybin.oslearn.http

import okhttp3.OkHttpClient

/**
 * Created by shortybin
 * on 2019-07-29
 */
object WAHttpClient : BaseHttpClient() {

    val apiService by lazy { getApiService(WanAndroidApi::class.java, WanAndroidApi.baseUrl) }

    override fun addHttpSetting(builder: OkHttpClient.Builder) {

    }

}