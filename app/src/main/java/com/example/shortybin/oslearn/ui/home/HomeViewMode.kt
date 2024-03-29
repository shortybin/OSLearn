package com.example.shortybin.oslearn.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.shortybin.oslearn.bean.BannerBean
import com.example.shortybin.oslearn.bean.HomeRecommendList
import com.example.shortybin.oslearn.http.WAHttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import luyao.util.ktx.base.BaseViewModel

/**
 * Created by shortybin
 * on 2019-07-31
 */
class HomeViewMode : BaseViewModel() {
    var mbannerList: MutableLiveData<List<BannerBean>> = MutableLiveData()
    var mrecommendList: MutableLiveData<HomeRecommendList> = MutableLiveData()

    fun getBanner() {
        launch {
            var result = withContext(Dispatchers.IO) {
                WAHttpClient.apiService.getBanner()
            }
            if (result.errorCode == -1) {

            } else {
                mbannerList.value = result.data
            }
        }
    }

    fun getHomeRecommend(page: Int) {
        launch {
            var result = withContext(Dispatchers.IO) {
                WAHttpClient.apiService.getHomeRecommend(page)
            }
            if (result.errorCode == -1) {

            } else {
                mrecommendList.value = result.data
            }
        }
    }

}