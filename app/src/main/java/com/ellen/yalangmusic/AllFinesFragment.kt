package com.ellen.yalangmusic

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.BaseFragment
import com.ellen.yalangmusic.bean.Android30

class AllFinesFragment : BaseFragment() {

    private lateinit var recyclerView: RecyclerView

    override fun getLayoutId(): Int {
        return R.layout.fragment_all_fines
    }

    override fun initView() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        var dataList:MutableList<Android30> = ArrayList()
        dataList.add(Android30())
        dataList.add(Android30())
        recyclerView.adapter = Android30Adapter(dataList,context!!)
    }

    override fun initData() {

    }
}