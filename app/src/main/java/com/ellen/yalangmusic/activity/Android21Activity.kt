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

class Android21Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_21)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val baseNullAdapter = BaseNullAdapter(this)
        recyclerView.adapter = baseNullAdapter

        //区域1
        val view1 = baseNullAdapter.addViewByLayoutId(0, R.layout.layout_android_21_1)

        //区域2
        val view2 = baseNullAdapter.addViewByLayoutId(1,R.layout.layout_android_21_2)

        val recyclerView2 = view2.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = DataAdapter(DataConfig.initData1(), this)
        //分割线
        val myDivider = MyDivider(
            this,
            MyDivider.VERTICAL
        )
        ContextCompat.getDrawable(
            this,
            R.drawable.line_recycler_view_mercury
        )?.let {
            myDivider.setDrawable(
                it
            )
        }
        recyclerView2.addItemDecoration(myDivider)

        //区域3
        val view3 = baseNullAdapter.addViewByLayoutId(
            2,
            R.layout.layout_android_7_2
        )
        val recyclerView3 = view3.findViewById<RecyclerView>(R.id.recycler_view)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView3.layoutManager = linearLayoutManager
        val android7IIList: MutableList<Android7II> = ArrayList()
        android7IIList.add(
            Android7II(
                "Get Help",
                R.mipmap.get_help,
                R.drawable.fillet_4_blaze_orange
            )
        )
        android7IIList.add(
            Android7II(
                "View docs",
                R.mipmap.view_docs,
                R.drawable.fillet_4_indigo
            )
        )
        android7IIList.add(
            Android7II(
                "Payments",
                R.mipmap.payments,
                R.drawable.fillet_4_indigo
            )
        )
        android7IIList.add(
            Android7II(
                "Cancel sub",
                R.mipmap.cancel_sub,
                R.drawable.fillet_4_burnt_sienna
            )
        )
        recyclerView3.adapter =
            Android7IIAdapter(android7IIList, this)

        //区域3
        val view4 = baseNullAdapter.addViewByLayoutId(
            3,
            R.layout.layout_android_7_3
        )
        val recyclerView4 = view4.findViewById<RecyclerView>(R.id.recycler_view_news)
        recyclerView4.layoutManager = LinearLayoutManager(this)
        val newsList: MutableList<News> = ArrayList()
        newsList.add(
            News(
                "Get 20% off first time servicing or repair vouchers",
                "Time for your regular servicing?Claim your first 20% off Servicing or repairs voucher with us"
            )
        )
        recyclerView4.adapter =
            NewsAdapter(newsList, this)
        recyclerView4.addItemDecoration(myDivider)
    }

}