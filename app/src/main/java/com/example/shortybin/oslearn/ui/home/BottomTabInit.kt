package com.example.shortybin.oslearn.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.example.shortybin.oslearn.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.bottom_item.view.*

/**
 * Created by shortybin
 * on 2019-08-08
 */
class BottomTabInit {
    val textList = arrayOf("首页", "体系", "导航", "项目", "我的")
    val iconId = arrayOf(
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
        , R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
    )

    fun tabLayoutInit(context: Context, tabLayout: TabLayout) {
        tabDataAdd(context, tabLayout)
    }

    fun tabDataAdd(context: Context, tabLayout: TabLayout) {
        tabLayout.apply {
            repeat(textList.size) {
                val inflate = LayoutInflater.from(context).inflate(R.layout.bottom_item, null)
                inflate.findViewById<TextView>(R.id.bottom_text_item).text = textList[it]
                inflate.findViewById<ImageView>(R.id.bottom_icon_item).setImageResource(iconId[it])
                val newTab = this.newTab()
                newTab.customView = inflate
                this.addTab(newTab)
            }
        }
    }
}