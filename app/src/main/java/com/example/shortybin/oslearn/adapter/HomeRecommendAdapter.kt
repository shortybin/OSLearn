package com.example.shortybin.oslearn.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shortybin.oslearn.R
import com.example.shortybin.oslearn.bean.HomeRecommendBean

/**
 * Created by shortybin
 * on 2019-08-12
 */
class HomeRecommendAdapter(layout: Int = R.layout.home_recommend_item) :
    BaseQuickAdapter<HomeRecommendBean, BaseViewHolder>(layout) {

    override fun convert(helper: BaseViewHolder, item: HomeRecommendBean) {
        helper.setText(R.id.author_name, item.author)
        helper.setText(R.id.article_category, item.superChapterName + " " + item.chapterName)
        helper.setText(R.id.arcicle_title, item.title)
        helper.setText(R.id.arcicle_time, item.publishTime.toString())
    }
}