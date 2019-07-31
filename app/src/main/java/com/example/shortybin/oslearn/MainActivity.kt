package com.example.shortybin.oslearn

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.shortybin.oslearn.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import luyao.util.ktx.base.BaseActivity

class MainActivity : BaseActivity() {

    var fragmentList = mutableListOf<Fragment>()

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    init {
        fragmentList.add(HomeFragment())
    }

    override fun initView() {

    }

    override fun initData() {
        mViewPage.adapter =
            object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
                override fun getItem(position: Int) = fragmentList[position]

                override fun getCount() = 1
            }
    }
}
