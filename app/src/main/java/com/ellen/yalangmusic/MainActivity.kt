package com.ellen.yalangmusic

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.BaseActivity
import com.ellen.base.adapter.BaseRecyclerViewAdapter
import com.ellen.yalangmusic.bean.Test
import com.ellen.yalangmusic.databinding.ActivityMainBinding

class MainActivity : BaseActivity(), View.OnClickListener {

    private var test = Test()
    private lateinit var recyclerView:RecyclerView

    override fun initMVVM() {
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.test = test
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var list:MutableList<String> = ArrayList()
        list.add("a")
        list.add("b")
        list.add("a")
        list.add("b")
        list.add("a")
        list.add("b")
        list.add("a")
        list.add("b")
        recyclerView.adapter = TestAdapter(this,list)
        if(recyclerView.adapter is BaseRecyclerViewAdapter) {
            //这里怎么声明泛型接口对象呢？
        }

        }

    override fun setStatus() {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}