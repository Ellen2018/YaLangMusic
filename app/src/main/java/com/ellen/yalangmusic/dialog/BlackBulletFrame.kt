package com.ellen.yalangmusic.dialog

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ellen.base.BasePopWindow
import com.ellen.yalangmusic.R

/**
 * 黑色弹框
 */
class BlackBulletFrame(activity:Activity):BasePopWindow(activity){

    override fun onCreateView(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.dialog_black,null)
    }

    override fun setWidth(): Int {
        return ViewGroup.LayoutParams.WRAP_CONTENT
    }

    override fun setHeight(): Int {
        return ViewGroup.LayoutParams.WRAP_CONTENT
    }

    override fun isGetFocus(): Boolean {
        return false
    }

    override fun isSetBackgroundDrawable(): Boolean {
       return false
    }

    override fun setBackgroundDrawable(): Drawable? {
       return null
    }

    override fun isResponseOutsideTouchable(): Boolean {
        return true
    }

    override fun isResponseTouchable(): Boolean {
       return true
    }

    override fun isSetShowBackgroundBlack(): Boolean? {
       return false
    }
}