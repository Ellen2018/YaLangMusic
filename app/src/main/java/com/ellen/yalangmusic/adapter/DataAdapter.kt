package com.ellen.yalangmusic.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewStub
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.ellen.base.adapter.BaseSingleRecyclerViewAdapter
import com.ellen.base.adapter.BaseViewHolder
import com.ellen.yalangmusic.R
import com.ellen.yalangmusic.bean.Android7KeyValue
import com.ellen.yalangmusic.dialog.BlackBulletFrame

/**
 * Android 5 & 7 & 40 界面都用到这个适配器
 *
 */
class DataAdapter(dataList:MutableList<Android7KeyValue>,mContext:Context) :
    BaseSingleRecyclerViewAdapter<DataAdapter.DataViewHolder, Android7KeyValue>(dataList,mContext) {


    class DataViewHolder(itemView:View) : BaseViewHolder(itemView){
        var tvKey = findViewById<TextView>(R.id.tv_key)
        var tvValue = findViewById<TextView>(R.id.tv_value)
        var viewStub = findViewById<ViewStub>(R.id.stub)
    }

    override fun getItemLayoutId(): Int {
        return R.layout.item_android_7_1
    }

    override fun getItemViewHolder(view: View): DataViewHolder {
       return DataViewHolder(view)
    }

    override fun showData(holder: DataViewHolder, data: Android7KeyValue, position: Int) {
       holder.tvKey.text = data.key
       holder.tvValue.text = data.value
       if(data.isShowTips) {
           holder.viewStub.visibility = View.VISIBLE
           var rlKey = holder.itemView.findViewById<RelativeLayout>(R.id.rl_key);
           rlKey.setOnClickListener {
               val blackBulletFrame = BlackBulletFrame(mContext as Activity)
               blackBulletFrame.showDownCenter(rlKey)
           }
       } else{
           holder.viewStub.visibility = View.GONE
       }
    }

}