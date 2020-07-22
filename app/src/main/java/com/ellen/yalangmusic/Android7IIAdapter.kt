package com.ellen.yalangmusic

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.ellen.base.adapter.BaseSingleRecyclerViewAdapter
import com.ellen.base.adapter.BaseViewHolder
import com.ellen.yalangmusic.bean.Android7II

class Android7IIAdapter(dataList:MutableList<Android7II>,mContext:Context)
    : BaseSingleRecyclerViewAdapter<Android7IIAdapter.Android7IIViewHolder,Android7II>(dataList,mContext){


    class Android7IIViewHolder(itemView:View) : BaseViewHolder(itemView){
        var tvContent = findViewById<TextView>(R.id.tv_content)
        var imageView = findViewById<ImageView>(R.id.iv)
        var rlBg = findViewById<RelativeLayout>(R.id.rl_background)
    }

    override fun getItemLayoutId(): Int {
        return R.layout.item_android_7_2
    }

    override fun getItemViewHolder(view: View): Android7IIViewHolder {
       return Android7IIViewHolder(view)
    }

    override fun showData(holder: Android7IIViewHolder, data: Android7II, position: Int) {
        holder.tvContent.text = data.content
        holder.imageView.setImageResource(data.imgId)
        holder.rlBg.setBackgroundResource(data.drawableId)
    }
}