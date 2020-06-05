package com.ellen.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatus()
        initMVVM()
    }

    abstract fun initMVVM()

    /**
     * 初始化状态栏
     */
    abstract fun setStatus()
}