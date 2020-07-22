package com.ellen.yalangmusic

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ellen.base.BasePopWindow
import com.ellen.base.adapter.BaseNullAdapter
import com.ellen.yalangmusic.bean.DataConfig


class Android41PopWindow(appCompatActivity: AppCompatActivity) : BasePopWindow(appCompatActivity) {

    private lateinit var ivBack:ImageView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(): View {
        val  view = LayoutInflater.from(getContext()).inflate(R.layout.activity_android_41,null)
        ivBack = view.findViewById(R.id.iv_cancel)
        ivBack.setOnClickListener {
            dismiss()
        }
        recyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(getContext())
        var baseNullAdapter = BaseNullAdapter(getContext()!!)
        recyclerView.adapter = baseNullAdapter
        val view1 = baseNullAdapter.addViewByLayoutId(0,R.layout.layout_android_40_1)
        val view2 = baseNullAdapter.addViewByLayoutId(1,R.layout.layout_android_40_1)
        view2.findViewById<TextView>(R.id.tv_title).text = "Regulatory Details"
        val recyclerView1 = view1.findViewById<RecyclerView>(R.id.recycler_view)
        val recyclerView2 = view2.findViewById<RecyclerView>(R.id.recycler_view)
        var myDivider = MyDivider(getContext(),MyDivider.VERTICAL)
        ContextCompat.getDrawable(getContext()!!,R.drawable.line_recycler_view_gary)?.let {
            myDivider.setDrawable(
                it
            )
        }
        recyclerView1.layoutManager = LinearLayoutManager(getContext())
        recyclerView2.layoutManager = LinearLayoutManager(getContext())
        recyclerView1.addItemDecoration(myDivider)
        recyclerView2.addItemDecoration(myDivider)
        recyclerView1.adapter = DataAdapter(DataConfig.initData1(),getContext()!!)
        recyclerView2.adapter = DataAdapter(DataConfig.initData2(),getContext()!!)
        return view
    }

    override fun setOtherSetting(popupWindow: PopupWindow?) {
        super.setOtherSetting(popupWindow)
        popupWindow!!.animationStyle = R.style.popwindow_anim_style
    }

    override fun setWidth(): Int {
       return ViewGroup.LayoutParams.MATCH_PARENT
    }

    override fun setHeight(): Int {
        return getContext()!!.resources.displayMetrics.heightPixels - 63 * 3
    }

    override fun isGetFocus(): Boolean {
        return true
    }

    override fun isSetBackgroundDrawable(): Boolean {
        return false
    }

    override fun setBackgroundDrawable(): Drawable? {
       return null
    }

    override fun isResponseOutsideTouchable(): Boolean {
       return false
    }

    override fun isResponseTouchable(): Boolean {
        return true
    }

    override fun isSetShowBackgroundBlack(): Boolean? {
        return true
    }

}