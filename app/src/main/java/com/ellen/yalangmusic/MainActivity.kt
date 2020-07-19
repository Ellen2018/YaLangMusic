package com.ellen.yalangmusic

import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.BaseActivity
import com.ellen.base.adapter.BaseRecyclerViewAdapter
import com.ellen.base.adapter.BaseViewHolder
import com.ellen.yalangmusic.bean.Test
import com.ellen.yalangmusic.databinding.ActivityMainBinding

class MainActivity : BaseActivity(), View.OnClickListener {

    private var test = Test()
    private lateinit var recyclerView: RecyclerView

    override fun initMVVM() {
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.test = test
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
        var testAdapter = TestAdapter(this, list)
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
        recyclerView.adapter = testAdapter
    }

    override fun setStatus() {
    }

    override fun onClick(v: View?) {
    }

}