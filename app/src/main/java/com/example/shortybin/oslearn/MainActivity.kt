package com.example.shortybin.oslearn

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.shortybin.oslearn.ui.home.*
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
        fragmentList.add(SystemFragment())
        fragmentList.add(NavigationFragment())
        fragmentList.add(ProjectFragment())
        fragmentList.add(MyFragment())
    }

    override fun initView() {
        mViewPage.adapter =
            object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
                override fun getItem(position: Int) = fragmentList[position]

                override fun getCount() = fragmentList.size
            }
        mTabLayout.setupWithViewPager(mViewPage)
        BottomTabInit().tabLayoutInit(this@MainActivity, mTabLayout)
    }

    override fun initData() {

    }
}
