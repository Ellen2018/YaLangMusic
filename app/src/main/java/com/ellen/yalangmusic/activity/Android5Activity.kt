package com.ellen.yalangmusic.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.adapter.BaseNullAdapter
import com.ellen.yalangmusic.R
import com.ellen.yalangmusic.adapter.Android7IIAdapter
import com.ellen.yalangmusic.adapter.DataAdapter
import com.ellen.yalangmusic.adapter.NewsAdapter
import com.ellen.yalangmusic.bean.Android7II
import com.ellen.yalangmusic.bean.DataConfig
import com.ellen.yalangmusic.bean.News
import com.ellen.yalangmusic.utils.MyDivider

class Android5Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val baseNullAdapter = BaseNullAdapter(this)
        recyclerView.adapter = baseNullAdapter

        val view1 = baseNullAdapter.addViewByLayoutId(0, R.layout.layout_5_1)

        val recyclerView1 = view1.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView1.adapter = DataAdapter(DataConfig.initData1(), this)
        var myDivider = MyDivider(
            this,
            MyDivider.VERTICAL
        )
        ContextCompat.getDrawable(
            this,
            R.drawable.line_recycler_view_gary
        )?.let {
            myDivider.setDrawable(
                it
            )
        }
        recyclerView1.addItemDecoration(myDivider)

        val view2 = baseNullAdapter.addViewByLayoutId(
            1,
            R.layout.layout_android_7_2
        )
        val recyclerView2 = view2.findViewById<RecyclerView>(R.id.recycler_view)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView2.layoutManager = linearLayoutManager
        val android7IIList: MutableList<Android7II> = ArrayList()
        android7IIList.add(
            Android7II(
                "Get Help",
                R.mipmap.get_help,
                R.drawable.yuan_jiao_blaze_orange
            )
        )
        android7IIList.add(
            Android7II(
                "View docs",
                R.mipmap.view_docs,
                R.drawable.yuan_jiao_indigo
            )
        )
        android7IIList.add(
            Android7II(
                "Payments",
                R.mipmap.payments,
                R.drawable.yuan_jiao_indigo
            )
        )
        android7IIList.add(
            Android7II(
                "Cancel sub",
                R.mipmap.cancel_sub,
                R.drawable.yuan_jiao_burnt_sienna
            )
        )
        recyclerView2.adapter =
            Android7IIAdapter(android7IIList, this)

        val view3 = baseNullAdapter.addViewByLayoutId(
            2,
            R.layout.layout_android_7_3
        )
        val recyclerView = view3.findViewById<RecyclerView>(R.id.recycler_view_news)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val newsList: MutableList<News> = ArrayList()
        newsList.add(
            News(
                "Get 20% off first time servicing or repair vouchers",
                "Time for your regular servicing?Claim your first 20% off Servicing or repairs voucher with us"
            )
        )
        recyclerView.adapter =
            NewsAdapter(newsList, this)
    }

}