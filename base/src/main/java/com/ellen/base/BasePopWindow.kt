package com.ellen.base


import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.ellen.javabase.base.BasePopWindow
import java.lang.ref.WeakReference

abstract class BasePopWindow() : ShowPopWindow {
    private lateinit var popWindow: PopupWindow
    private lateinit var activityWeakReference: WeakReference<Activity>
    protected lateinit var mContentView:View
    var onDismissListener: BasePopWindow.OnDismissListener? = null

    constructor(activity: AppCompatActivity) : this() {
        activityWeakReference = WeakReference(activity)
    }

    private fun showInit(){
        mContentView = onCreateView()
        popWindow = PopupWindow(mContentView,setWidth(),setHeight(),isGetFocus())
        if(isSetBackgroundDrawable()){
            popWindow.setBackgroundDrawable(setBackgroundDrawable())
        }
        // 设置PopupWindow是否能响应外部点击事件
        popWindow.isOutsideTouchable = isResponseOutsideTouchable()
        // 设置PopupWindow是否能响应点击事件
        popWindow.isTouchable = isResponseTouchable()
        //设置其它，例如：可以通过这个方法完成虚拟键盘适配等
        setOtherSetting(popWindow)
        popWindow.setOnDismissListener(PopupWindow.OnDismissListener {
            if (onDismissListener != null) {
                onDismissListener!!.dismiss()
            }
            //判断是否暗化
            if (isSetShowBackgroundBlack()!!) {
                //去掉暗色背景
                val lp =
                    activityWeakReference.get()!!.window.attributes
                lp.alpha = 1.0f
                activityWeakReference.get()!!.window
                    .clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                activityWeakReference.get()!!.window.attributes = lp
            }
        })
        if (isSetShowBackgroundBlack()!!) {
            val lp =
                activityWeakReference.get()!!.window.attributes
            lp.alpha = 0.3f
            activityWeakReference.get()!!.window
                .addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            activityWeakReference.get()!!.window.attributes = lp
        }
    }

    protected open fun <T : View?> findViewById(id: Int): T {
        return mContentView.findViewById<T>(id)
    }

    override fun showAsDropDown(parentView: View) {
        showInit()
        popWindow.showAsDropDown(parentView)
    }

    override fun showAsDropDown(parentView: View, x: Int, y: Int) {
        showInit()
        popWindow.showAsDropDown(parentView,x,y)
    }

    override fun showAsDropDown(parentView: View, x: Int, y: Int, gravity: Int) {
        showInit()
        popWindow.showAsDropDown(parentView,x,y,gravity)
    }

    override fun showAtLocation(parentView: View, gravity: Int, x: Int, y: Int) {
        showInit()
        popWindow.showAtLocation(parentView,gravity,x,y)
    }

    override fun dismiss() {
        dismissBefore()
        //解除绑定
        //如果设置了背景暗化，那么这里去除背景暗化
        if (isSetShowBackgroundBlack()!!) {
            //去掉暗色背景
            val lp =
                activityWeakReference.get()!!.window.attributes
            lp.alpha = 1.0f
            activityWeakReference.get()!!.window
                .clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            activityWeakReference.get()!!.window.attributes = lp
        }
        popWindow.dismiss()
    }

    override fun setOtherSetting(popupWindow: PopupWindow?) {
    }

    override fun dismissBefore() {
    }

    override fun showBefore() {
    }

    override fun getContext(): Context? {
        return activityWeakReference.get()
    }


}

private interface ShowPopWindow{
    fun showAsDropDown(parentView: View)
    fun showAsDropDown(parentView:View, x:Int,y:Int)
    fun showAsDropDown(parentView:View, x:Int,y:Int, gravity:Int)
    fun showAtLocation(parentView:View, gravity:Int,x:Int,y:Int)
    fun dismiss()
    //创建PopWindow的View
    fun onCreateView(): View
    //设置宽度
    fun setWidth(): Int
    //设置高度
    fun setHeight(): Int
    //是否获取焦点
    fun isGetFocus(): Boolean
    //是否设置背景Drawable
    fun isSetBackgroundDrawable(): Boolean
    //设置背景Drawable
    fun setBackgroundDrawable(): Drawable?
    //是否响应应外部点击事件
    fun isResponseOutsideTouchable(): Boolean
    //是否相应内部点击事件
    fun isResponseTouchable(): Boolean
    //设置其它
    fun setOtherSetting(popupWindow: PopupWindow?)
    //设置背景暗化
    fun isSetShowBackgroundBlack(): Boolean?
    //dismiss之前调用
    fun dismissBefore()
    fun showBefore()
    fun  getContext():Context?
}

