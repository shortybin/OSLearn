package com.example.shortybin.oslearn

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.shortybin.oslearn.http.BaseHttpClient
import com.example.shortybin.oslearn.http.WAHttpClient
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
        BaseViewModel().viewModelScope.launch {
            val banner = WAHttpClient.apiService.getBanner()
            Log.d("123", banner.errorCode.toString())
        }
    }
}
