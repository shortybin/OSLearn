package com.example.shortybin.oslearn.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shortybin.oslearn.R
import com.example.shortybin.oslearn.http.WAHttpClient
import com.example.shortybin.oslearn.utils.GlideImageLoader
import kotlinx.android.synthetic.main.fragment_home.*
import luyao.util.ktx.base.BaseVMFragment

/**
 * Created by shortybin
 * on 2019-07-29
 */
class HomeFragment : BaseVMFragment<HomeViewMode>() {

    override fun providerVMClass() = HomeViewMode::class.java

    var mBannerImages = mutableListOf<String>()

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        mBanner.setImageLoader(GlideImageLoader())
        mHomeRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
    }

    override fun initData() {
        mViewModel.launch {
            val banner = WAHttpClient.apiService.getBanner()
            mBannerImages = banner.data.flatMap {
                listOf(it.imagePath)
            }.toMutableList()
            mBanner.setImages(mBannerImages)
            mBanner.start()
        }
    }
}