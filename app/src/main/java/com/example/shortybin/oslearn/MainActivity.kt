package com.example.shortybin.oslearn

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.shortybin.oslearn.http.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.base.BaseViewModel

class MainActivity : BaseActivity() {
    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initData() {
        val httpClient = HttpClient.getHttpClient()


        BaseViewModel().viewModelScope.launch {
            val banner = httpClient.getBanner()

            Log.d("123", banner.errorCode.toString())

        }

    }
}
