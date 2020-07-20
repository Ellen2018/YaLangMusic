package com.ellen.yalangmusic

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.BaseActivity
import com.ellen.yalangmusic.bean.Android7KeyValue
import com.ellen.yalangmusic.databinding.ActivityMainBinding

class MainActivity : BaseActivity(), View.OnClickListener {
    
    private lateinit var recyclerView: RecyclerView
    private var android7KeyValue = Android7KeyValue("a",false,"a")

    override fun initMVVM() {
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.test = android7KeyValue
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var list: MutableList<String> = ArrayList()
        list.add("a")
        list.add("b")
        list.add("a")
        list.add("b")
        list.add("a")
        list.add("b")
        list.add("a")
        list.add("b")

//        testAdapter.onItemClickListener = object :
//            BaseRecyclerViewAdapter.OnItemClickListener<TestAdapter.TestViewHolder, String> {
//            override fun onItemClick(
//                holder: TestAdapter.TestViewHolder,
//                data: String,
//                position: Int
//            ) {
//                Toast.makeText(testAdapter.mContext, data, Toast.LENGTH_SHORT).show()
//            }
//
//        }
//
//        testAdapter.onItemLongClickListener =
//            object :
//                BaseRecyclerViewAdapter.OnItemLongClickListener<TestAdapter.TestViewHolder, String> {
//                override fun onItemLongClick(
//                    holder: TestAdapter.TestViewHolder,
//                    data: String,
//                    position: Int
//                ): Boolean {
//                    return true
//                }
//
//            }
    }

    override fun setStatus() {
    }

    override fun onClick(v: View?) {
    }

}