package com.ellen.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseSingleRecyclerViewAdapter<VH : BaseViewHolder, D>(
    var dataList: List<D>,
    var mContext: Context
) : BaseRecyclerViewAdapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        var view = LayoutInflater.from(mContext).inflate(getItemLayoutId(), null)
        return getItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        showData(holder, dataList[position], position)
        if(onItemClickListener != null){
            holder.itemView.setOnClickListener {
                onItemClickListener.onItemClick(holder as Nothing,position)
            }
        }
    }

    /**
     * 子Item的布局id
     */
    abstract fun getItemLayoutId(): Int

    /**
     * 子item对应的ViewHolder
     */
    abstract fun getItemViewHolder(view: View): VH

    abstract fun showData(holder: VH, data: D, position: Int)
}