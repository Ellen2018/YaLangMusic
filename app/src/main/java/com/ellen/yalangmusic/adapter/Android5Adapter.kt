package com.ellen.yalangmusic.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import com.ellen.base.adapter.BaseNullAdapter
import com.ellen.base.adapter.BaseSingleRecyclerViewAdapter
import com.ellen.yalangmusic.R
import com.ellen.yalangmusic.bean.YourNameDivers

class Android5Adapter(dataList:MutableList<YourNameDivers>,mContext:Context)
    : BaseSingleRecyclerViewAdapter<Android5Adapter.Android5ViewHolder,YourNameDivers>(dataList,mContext){


    class Android5ViewHolder(itemView: View) : com.ellen.base.adapter.BaseViewHolder(itemView){
        var tvKey = findViewById<TextView>(R.id.tv_key)
        var tvValue = findViewById<TextView>(R.id.tv_value)
    }

    override fun getItemLayoutId(): Int {
        return R.layout.item_android_5
    }

    override fun getItemViewHolder(view: View): Android5ViewHolder {
        return Android5ViewHolder(view)
    }

    override fun showData(holder: Android5ViewHolder, data: YourNameDivers, position: Int) {
        holder.tvKey.text = data.key
        holder.tvValue.text = data.value
    }
}