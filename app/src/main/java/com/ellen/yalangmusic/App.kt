package com.ellen.yalangmusic

import android.app.Application
import android.util.Log
import com.ellen.base.app.AppLifeListener

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object : AppLifeListener() {

            override fun onAppLaunch(isColdLaunch: Boolean) {
               if(isColdLaunch){
                   //冷启动
               }else{
                   //热启动 & 温启动
               }
            }


            override fun onSwitchBack() {
                //app切换至后台
                Log.e("Ellen2018", "后台")
            }

            override fun onSwitchFront() {
                //app切换至前台
                Log.e("Ellen2018", "前台")
            }

            override fun onCloseApp() {
                //app关闭了
                Log.e("Ellen2018", "关闭")
            }
        });
    }

}