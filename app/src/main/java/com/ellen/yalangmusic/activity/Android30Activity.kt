package com.ellen.yalangmusic.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.ellen.javabase.adapter.viewpager.BaseFragmentStateAdapter
import com.ellen.yalangmusic.fragment.AllFinesFragment
import com.ellen.yalangmusic.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.adapter.FragmentStateAdapter as Frag

class Android30Activity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_30)
        tabLayout = findViewById(R.id.tab_layout)
        viewPager2 = findViewById(R.id.view_pager)
        tabLayout.setSelectedTabIndicator(null)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.adapter = object : androidx.viewpager2.adapter.FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int): Fragment {
                return AllFinesFragment()
            }

        }

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.setCustomView(R.layout.item_tab_layout)
            val tv = tab.customView!!.findViewById<TextView>(R.id.tv_text)
            when (position) {
              0-> tv.text = "All Fines"
                1-> tv.text = "Oustanding"
                2-> tv.text = "Resolved"
            }
        }.attach()

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