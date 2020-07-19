package com.ellen.yalangmusic

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.javabase.adapter.recyclerview.SuperRecyclerViewAdapter

class Android7Activity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_7)
        recyclerView = findViewById(R.id.recycler_view)
        var dataList:MutableList<String> = ArrayList()
        var carAdapter:CarAdapter = CarAdapter(this,dataList)
        recyclerView.adapter = carAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        carAdapter.addHeaderView(LayoutInflater.from(this).inflate(R.layout.layout_android_7_1,null))

    }

}