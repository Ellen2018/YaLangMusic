package com.ellen.yalangmusic

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ellen.base.BaseActivity
import com.ellen.javabase.utils.statusutil.StatusUtils
import com.ellen.yalangmusic.bean.Test
import com.ellen.yalangmusic.databinding.ActivityMainBinding

class MainActivity : BaseActivity(), View.OnClickListener {

    private var test = Test()

    override fun initMVVM() {
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.test = test
    }

    override fun setStatus() {
        StatusUtils.setNoActionBar(this)
        StatusUtils.setTranslucentStatus(this)
        //设置主题为深色
        StatusUtils.setStatusBarDarkTheme(this,true)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onClick(v: View?) {

    }

}