package com.ellen.base.adapter

import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerViewAdapter<T:BaseViewHolder> : RecyclerView.Adapter<T>() {
    lateinit var onItemClickListener:OnItemClickListener<T>
    lateinit var onItemLongClickListener: OnItemLongClickListener<T>

    interface OnItemClickListener<T : BaseViewHolder> {
        fun onItemClick(t:T,position:Int)
    }

    interface OnItemLongClickListener<T : BaseViewHolder>{
        fun onItemLongClick(t:T,position: Int)
    }
}


