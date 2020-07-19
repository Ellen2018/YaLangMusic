package com.ellen.yalangmusic

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.adapter.BaseNullAdapter

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        recyclerView =  findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val baseNullAdapter = BaseNullAdapter(this)
        recyclerView.adapter = baseNullAdapter
        var view = baseNullAdapter.addViewByLayoutId(1,R.layout.layout_1)
        baseNullAdapter.addViewByLayoutId(2,R.layout.layout_2)
        baseNullAdapter.addViewByLayoutId(3,R.layout.layout_0)

        baseNullAdapter.removePosition(2)
    }

}