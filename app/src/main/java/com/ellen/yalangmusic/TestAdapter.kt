package com.ellen.yalangmusic

import android.content.Context
import android.view.View
import android.widget.TextView
import com.ellen.base.adapter.BaseSingleRecyclerViewAdapter
import com.ellen.base.adapter.BaseViewHolder
import com.ellen.yalangmusic.bean.Test

class TestAdapter(mContext:Context,dataList:List<String>) :
    BaseSingleRecyclerViewAdapter<TestAdapter.TestViewHolder, String>(dataList,mContext) {


    class TestViewHolder : BaseViewHolder{

        var tv:TextView = findViewById(R.id.tv_example)

        constructor(itemView:View) : super(itemView)

    }

    override fun getItemLayoutId(): Int {
        return R.layout.item_test
    }

    override fun getItemViewHolder(view: View): TestViewHolder {
        return TestViewHolder(view)
    }

    override fun showData(holder: TestViewHolder, data: String, position: Int) {
        holder.tv.text = data
    }

}