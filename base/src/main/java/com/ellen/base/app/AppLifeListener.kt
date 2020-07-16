package com.ellen.base.app

import android.app.Activity
import android.app.Application
import android.os.Bundle

abstract class AppLifeListener:Application.ActivityLifecycleCallbacks{

    private var lifeActivityCount = 0
    private var isAppBack = false
    //是否冷启动
    private var isColdLaunch = true
    //kotlin中ArrayList应该这么new
    private var activityList: MutableList<Activity> = ArrayList()

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        activityList.remove(activity)
        if(activityList.size == 0){
            onCloseApp()

            //进行初始化
            lifeActivityCount = 0
            isAppBack = false
            activityList = ArrayList()
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityStopped(activity: Activity) {
        lifeActivityCount--
        if(lifeActivityCount == 0){
            onSwitchBack()
            isAppBack = true
        }
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if(lifeActivityCount == 0){
            if(isColdLaunch) {
                //冷启动
                onAppLaunch(true)
                isColdLaunch = false
            }else{
                //热启动 & 温启动
                onAppLaunch(false)
            }
        }
        activityList.add(activity)
    }

    override fun onActivityResumed(activity: Activity) {
        lifeActivityCount++
        if(isAppBack){
            onSwitchFront()
            isAppBack = false
        }
    }

    /**
     * 只要应用启动就会调用
     * isColdLaunch:是否冷启动
     */
    protected abstract fun onAppLaunch(isColdLaunch: Boolean)

    /**
     * 切换至后台时调用
     */
    protected abstract fun onSwitchBack()

    /**
     * 从后台切换至前台时调用
     */
    protected abstract fun onSwitchFront()

    /**
     * 关闭应用时回调
     */
    protected abstract fun onCloseApp()
}