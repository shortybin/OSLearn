package com.example.shortybin.oslearn.http

import com.example.shortybin.oslearn.BannerBean
import retrofit2.http.GET

/**
 * Created by shortybin
 * on 2019-07-26
 */
interface WanAndroidApi {
    @GET("/banner/json")
    suspend fun getBanner(): BannerBean
}