package com.ellen.yalangmusic

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.adapter.BaseNullAdapter
import com.ellen.yalangmusic.bean.Android7II
import com.ellen.yalangmusic.bean.DataConfig
import com.ellen.yalangmusic.bean.News

class Android7Activity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_7)
        recyclerView = findViewById(R.id.recycler_view)
        var baseNullAdapter = BaseNullAdapter(this)
        recyclerView.adapter = baseNullAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        var view = baseNullAdapter.addViewByLayoutId(0,R.layout.layout_android_7_1)
        view.findViewById<TextView>(R.id.tv_view_detailed).setOnClickListener {
            val appCompatActivity = this@Android7Activity
           val android41PopWindow = Android41PopWindow(appCompatActivity)
            android41PopWindow.showAtLocation(recyclerView,Gravity.BOTTOM,0,0)
        }
        var recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        var myDivider = MyDivider(this,MyDivider.VERTICAL)
        ContextCompat.getDrawable(this,R.drawable.line_recycler_view_gary)?.let {
            myDivider.setDrawable(
                it
            )
        }
        recyclerView.addItemDecoration(myDivider)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = DataAdapter(DataConfig.getInitDataToAndroid7(),this)
        val view2 = baseNullAdapter.addViewByLayoutId(1,R.layout.layout_android_7_2)
        val recyclerView2 = view2.findViewById<RecyclerView>(R.id.recycler_view)
        val  linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView2.layoutManager = linearLayoutManager
        val android7IIList:MutableList<Android7II> = ArrayList()
        android7IIList.add(Android7II("Sell car",R.mipmap.sell_car,R.drawable.yuan_jiao_indigo))
        android7IIList.add(Android7II("Book svc",R.mipmap.book_svc,R.drawable.yuan_jiao_indigo))
        android7IIList.add(Android7II("View docs",R.mipmap.view_docs,R.drawable.yuan_jiao_indigo))
        recyclerView2.adapter = Android7IIAdapter(android7IIList,this)

        var recyclerViewNews = baseNullAdapter.
        addViewByLayoutId(2,R.layout.layout_android_7_3).findViewById<RecyclerView>(R.id.recycler_view_news)
        recyclerViewNews.layoutManager = LinearLayoutManager(this)
        recyclerViewNews.addItemDecoration(myDivider)
        var newsList:MutableList<News> = ArrayList()
        newsList.add(News("Free Inspection","Understand your car condition,get a free first time car inspection on us!"))
        newsList.add(News("Get 20% off first time servicing or repair vouchers","Time for your regular servicing?Claim your first 20% off Servicing or repairs voucher with us"))
        recyclerViewNews.adapter = NewsAdapter(newsList,this)
    }

}