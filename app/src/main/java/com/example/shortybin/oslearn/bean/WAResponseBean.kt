package com.example.shortybin.oslearn.bean

/**
 * Created by shortybin
 * on 2019-07-29
 */
data class WAResponseBean<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String
)