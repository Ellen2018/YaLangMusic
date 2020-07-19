package com.ellen.base.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.HashMap

/**
 * 没有任何数据类型的item,在代码中动态添加item
 */
class BaseNullAdapter(var mContext: Context) :
    RecyclerView.Adapter<BaseNullAdapter.PositionViewHolder>() {

    private var typeMap: SortedMap<Int, Int>? = null
    private var viewMap: MutableMap<Int, View>? = null
    private var adjustMap:MutableMap<Int,Int>? = null
    private lateinit var recyclerView:RecyclerView


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    fun addView(position: Int, view: View) {
        if (typeMap == null) {
            typeMap = TreeMap()
        }
        typeMap!![position] = position
        if(viewMap == null){
            viewMap = HashMap()
        }
        adjust()
        viewMap!![position] = view
        notifyDataSetChanged()
    }

    private fun adjust(){
        adjustMap = HashMap()
        var p = 0
        for((key,value) in typeMap!!){
            adjustMap!![p] = key
            p++
        }
    }

    fun removeView(view:View){
        var typeValue = -1
        for((key,value) in viewMap!!){
            if(view == value){
                typeValue = key
            }
        }
        if(typeValue >= 0) {
            removePosition(typeValue)
        }
    }

    fun  removePosition(position: Int){
        var removePosition = -1
        for((key,value) in adjustMap!!) {
            if(value == position){
                removePosition = key
            }
        }
        if(removePosition >= 0) {
            adjustMap!!.remove(removePosition)
            typeMap!!.remove(position)
            viewMap!!.remove(position)
            adjust()
            notifyDataSetChanged()
        }
    }

    fun addViewByLayoutId(position: Int,id:Int):View{
        val view = LayoutInflater.from(mContext).inflate(id,null)
        addView(position,view)
        return view
    }


    override fun getItemViewType(position: Int): Int {
        var p = adjustMap!![position]
        var typeValue = typeMap!![p]
        return typeValue!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        val view = viewMap!![viewType]
        return PositionViewHolder(view!!, viewType)
    }

    override fun getItemCount(): Int {
        return adjustMap!!.size
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {

    }

    class PositionViewHolder(itemView: View, var itemType: Int) : BaseViewHolder(itemView) {

    }
}