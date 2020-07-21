package com.ellen.yalangmusic

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.adapter.BaseNullAdapter
import com.ellen.javabase.uitil.statusutil.StatusUtils
import com.ellen.yalangmusic.bean.DataConfig


class Android41Activity : AppCompatActivity(){

    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusUtils.setFullScreen(this)
        StatusUtils.setNoActionBar(this)
        setContentView(R.layout.activity_android_41)
        findViewById<ImageView>(R.id.iv_cancel).setOnClickListener {
            finish()
        }
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var baseNullAdapter = BaseNullAdapter(this)
        recyclerView.adapter = baseNullAdapter
        val view1 = baseNullAdapter.addViewByLayoutId(0,R.layout.layout_android_40_1)
        val view2 = baseNullAdapter.addViewByLayoutId(1,R.layout.layout_android_40_1)
        val recyclerView1 = view1.findViewById<RecyclerView>(R.id.recycler_view)
        val recyclerView2 = view2.findViewById<RecyclerView>(R.id.recycler_view)
        var myDivider = MyDivider(this,MyDivider.VERTICAL)
        ContextCompat.getDrawable(this,R.drawable.line_recycler_view_gary)?.let {
            myDivider.setDrawable(
                it
            )
        }
        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView1.addItemDecoration(myDivider)
        recyclerView2.addItemDecoration(myDivider)
        recyclerView1.adapter = DataAdapter(DataConfig.initData1(),this)
        recyclerView2.adapter = DataAdapter(DataConfig.initData2(),this)
    }

}