package com.example.shortybin.oslearn.bean

/**
 * Created by shortybin
 * on 2019-07-26
 */
data class BannerBean(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)