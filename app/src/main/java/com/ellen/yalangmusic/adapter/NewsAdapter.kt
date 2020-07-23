package com.ellen.yalangmusic.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import com.ellen.base.adapter.BaseSingleRecyclerViewAdapter
import com.ellen.base.adapter.BaseViewHolder
import com.ellen.yalangmusic.R
import com.ellen.yalangmusic.bean.News

class NewsAdapter(dataList:MutableList<News>,mContext:Context) :
    BaseSingleRecyclerViewAdapter<NewsAdapter.NewsViewHolder, News>(dataList,mContext) {


    class NewsViewHolder(itemView: View) : BaseViewHolder(itemView){
        var tvTitle = findViewById<TextView>(R.id.tv_title)
        var tvContent = findViewById<TextView>(R.id.tv_content)
    }

    override fun getItemLayoutId(): Int {
       return R.layout.item_android_7_3
    }

    override fun getItemViewHolder(view: View): NewsViewHolder {
        return NewsViewHolder(view)
    }

    override fun showData(holder: NewsViewHolder, data: News, position: Int) {
        holder.tvTitle.text = data.newTitle
        holder.tvContent.text = data.newsContent
    }

}