package com.ellen.yalangmusic.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.adapter.BaseNullAdapter
import com.ellen.yalangmusic.R
import com.ellen.yalangmusic.adapter.Android5Adapter
import com.ellen.yalangmusic.bean.YourNameDivers

class Android5Activity : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)

        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val baseNullAdapter = BaseNullAdapter(this)
        recyclerView.adapter = baseNullAdapter

        //区域1
        baseNullAdapter.addViewByLayoutId(0,R.layout.layout_android_21_1)
        //区域2
        baseNullAdapter.addViewByLayoutId(1,R.layout.layout_android_5_2)
        //区域3
        val view3 = baseNullAdapter.addViewByLayoutId(2,R.layout.layout_android_5_3)
        val recyclerView3 = view3.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView3.layoutManager = GridLayoutManager(this,3)
        val dataList:MutableList<YourNameDivers> = ArrayList()
        dataList.add(YourNameDivers("Mobile Number","90685298"))
        dataList.add(YourNameDivers("National ID","*****631Z"))
        dataList.add(YourNameDivers("Driving Licence No","*****631Z"))
        dataList.add(YourNameDivers("Date of Birth","16 Apr 1980"))
        dataList.add(YourNameDivers("Marital Status","Married "))
        dataList.add(YourNameDivers("Licence Reg Date","16 Apr 2000"))
        dataList.add(YourNameDivers("Gender","Male"))
        dataList.add(YourNameDivers("",""))
        dataList.add(YourNameDivers("Driving Exp(Years)","10"))
        recyclerView3.adapter = Android5Adapter(dataList,this)

        //区域4
        baseNullAdapter.addViewByLayoutId(3,R.layout.layout_android_5_4)
    }

}