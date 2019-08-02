package com.example.shortybin.oslearn.ui.home

import androidx.lifecycle.Observer
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
        initBanner()

        mViewModel.getBanner()
    }

    override fun startObserve() {
        super.startObserve()
        mViewModel.mbannerList.observe(this@HomeFragment, Observer { it ->
            mBannerImages = it.flatMap {
                listOf(it.imagePath)
            }.toMutableList()
            mBanner.setImages(mBannerImages)
            mBanner.start()
        })
    }

    fun initBanner() {

    }
}