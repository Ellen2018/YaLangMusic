package com.ellen.yalangmusic.adapter

import android.content.Context
import android.view.View
import com.ellen.base.adapter.BaseSingleRecyclerViewAdapter
import com.ellen.base.adapter.BaseViewHolder
import com.ellen.yalangmusic.R
import com.ellen.yalangmusic.bean.Android30

class Android30Adapter(dataList: MutableList<Android30>, mContext: Context) :
    BaseSingleRecyclerViewAdapter<Android30Adapter.Android30ViewHolder, Android30>(
        dataList,
        mContext
    ) {


    class Android30ViewHolder(itemView: View) : BaseViewHolder(itemView)

    override fun getItemLayoutId(): Int {
        return R.layout.item_layout_android_30
    }

    override fun getItemViewHolder(view: View): Android30ViewHolder {
        return Android30ViewHolder(
            view
        )
    }

    override fun showData(holder: Android30ViewHolder, data: Android30, position: Int) {

    }

}