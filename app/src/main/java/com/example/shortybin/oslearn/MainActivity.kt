package com.example.shortybin.oslearn

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.shortybin.oslearn.ui.home.BottomTabInit
import com.example.shortybin.oslearn.ui.home.HomeFragment
import com.google.android.material.tabs.TabLayout
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
        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
            }
        })
        BottomTabInit().tabLayoutInit(this@MainActivity, mTabLayout)
    }

    override fun initData() {
        mViewPage.adapter =
            object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
                override fun getItem(position: Int) = fragmentList[position]

                override fun getCount() = 1
            }
    }
}
