package com.example.shortybin.oslearn.http

import com.example.shortybin.oslearn.bean.BannerBean
import com.example.shortybin.oslearn.bean.WAResponseBean
import retrofit2.http.GET

/**
 * Created by shortybin
 * on 2019-07-26
 */
interface WanAndroidApi {

    companion object {
        const val baseUrl = "https://www.wanandroid.com"
    }

    @GET("/banner/json")
    suspend fun getBanner(): WAResponseBean<List<BannerBean>>
}