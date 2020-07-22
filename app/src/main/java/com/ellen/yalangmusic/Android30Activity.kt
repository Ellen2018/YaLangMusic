package com.ellen.yalangmusic

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ellen.javabase.adapter.viewpager.BaseFragmentStateAdapter
import com.google.android.material.tabs.TabLayout

class Android30Activity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_30)
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)
        tabLayout.setSelectedTabIndicator(null)
        viewPager.adapter = object : BaseFragmentStateAdapter(supportFragmentManager) {
            override fun getFragmentPagerSize(): Int {
                return 3
            }

            override fun getFragment(position: Int): Fragment {
                return if (position == 0) {
                    AllFinesFragment()
                } else if (position == 1) {
                    AllFinesFragment()
                } else {
                    AllFinesFragment()
                }
            }
        }
        tabLayout.setupWithViewPager(viewPager)
        for (index in 0..2) {
            var tab = tabLayout.getTabAt(index)
            tab!!.setCustomView(R.layout.item_tab_layout)
            val tv = tab.customView!!.findViewById<TextView>(R.id.tv_text)
            tv.text = if(index == 0){
                "All Fines"
            }else if(index == 1){
                "Oustanding"
            }else{
                "Resolved"
            }
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
                val tv = p0!!.customView!!.findViewById<TextView>(R.id.tv_text)
                tv.setBackgroundResource(R.drawable.yuan_jiao_left_right_gary)
                tv.setTextColor(Color.parseColor("#FC5600"))
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                val tv = p0!!.customView!!.findViewById<TextView>(R.id.tv_text)
                tv.background = null
                tv.setTextColor(Color.parseColor("#595959"))
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                val tv = p0!!.customView!!.findViewById<TextView>(R.id.tv_text)
                tv.setBackgroundResource(R.drawable.yuan_jiao_left_right_gary)
                tv.setTextColor(Color.parseColor("#FC5600"))
            }
        })
        tabLayout.getTabAt(0)!!.select()
    }

}