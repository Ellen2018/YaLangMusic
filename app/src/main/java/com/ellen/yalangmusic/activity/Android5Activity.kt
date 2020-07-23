package com.ellen.yalangmusic.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.adapter.BaseNullAdapter
import com.ellen.yalangmusic.R
import com.ellen.yalangmusic.adapter.Android5Adapter
import com.ellen.yalangmusic.bean.UserIDCardMessage

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
        //这里需要调间距
        recyclerView3.layoutManager = GridLayoutManager(this,3)
        val dataList:MutableList<UserIDCardMessage> = ArrayList()
        dataList.add(UserIDCardMessage("Mobile Number","90685298"))
        dataList.add(UserIDCardMessage("National ID","*****631Z"))
        dataList.add(UserIDCardMessage("Driving Licence No","*****631Z"))
        dataList.add(UserIDCardMessage("Date of Birth","16 Apr 1980"))
        dataList.add(UserIDCardMessage("Marital Status","Married "))
        dataList.add(UserIDCardMessage("Licence Reg Date","16 Apr 2000"))
        dataList.add(UserIDCardMessage("Gender","Male"))
        dataList.add(UserIDCardMessage("",""))
        dataList.add(UserIDCardMessage("Driving Exp(Years)","10"))
        recyclerView3.adapter = Android5Adapter(dataList,this)

        //区域4
        baseNullAdapter.addViewByLayoutId(3,R.layout.layout_android_5_4)
    }

}