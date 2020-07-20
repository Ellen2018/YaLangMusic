package com.ellen.yalangmusic

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.ellen.base.adapter.BaseNullAdapter
import com.ellen.javabase.adapter.recyclerview.SuperRecyclerViewAdapter
import com.ellen.yalangmusic.bean.Android7KeyValue
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
        var recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        var myDivider = MyDivider(this,MyDivider.VERTICAL)
        ContextCompat.getDrawable(this,R.drawable.line_recycler_view_gary)?.let {
            myDivider.setDrawable(
                it
            )
        }
        recyclerView.addItemDecoration(myDivider)
        recyclerView.layoutManager = LinearLayoutManager(this)
        DataConfig.datas = ArrayList()
        DataConfig.datas.add(Android7KeyValue("Inspection due date",false,"11 Nov 2020"))
        DataConfig.datas.add(Android7KeyValue("Road Tax Expiry Date",false,"11 Nov 2020"))
        DataConfig.datas.add(Android7KeyValue("COE Expiry Date",false,"5 May 2021"))
        DataConfig.datas.add(Android7KeyValue("Current paper value",true,"\$45,190"))
        DataConfig.datas.add(Android7KeyValue("Scrap value",true,"\$36,000"))
        DataConfig.datas.add(Android7KeyValue("Fines",true,"2 outstanding(View more)"))
        DataConfig.datas.add(Android7KeyValue("Recalls",true,"3 found(View more)"))
        recyclerView.adapter = DataAdapter(DataConfig.datas,this)
        baseNullAdapter.addViewByLayoutId(1,R.layout.layout_android_7_2)
        var recyclerViewNews = baseNullAdapter.
        addViewByLayoutId(2,R.layout.layout_android_7_3).findViewById<RecyclerView>(R.id.recycler_view_news)
        recyclerViewNews.layoutManager = LinearLayoutManager(this)
        var newsList:MutableList<News> = ArrayList()
        newsList.add(News("Free Inspection","Understand your car condition,get a free first time car inspection on us!"))
        newsList.add(News("Get 20% off first time servicing or repair vouchers","Time for your regular servicing?Claim your first 20% off Servicing or repairs voucher with us"))
        recyclerViewNews.adapter = NewsAdapter(newsList,this)
    }

}