package com.ellen.javabase.simpleapi.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class AppLifeListener implements Application.ActivityLifecycleCallbacks {

    private int lifeActivityCount = 0;
    private boolean isAppBack = false;
    //是否冷启动
    private boolean isColdLaunch = true;
    private List<Activity> activityList;

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        if (lifeActivityCount == 0) {
            if(isColdLaunch) {
                onAppLaunch(true);
                isColdLaunch = false;
            }else {
                onAppLaunch(false);
            }
        }
        if (activityList == null) {
            activityList = new ArrayList<>();
        }
        activityList.add(activity);
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        lifeActivityCount++;
        if (isAppBack) {
            //从后台切换至前台
            onSwitchFront();
            isAppBack = false;
        }
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        lifeActivityCount--;
        if (lifeActivityCount == 0) {
            //切换至后台了
            isAppBack = true;
            onSwitchBack();
        }
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        activityList.remove(activity);
        if (activityList != null && activityList.size() == 0) {
            onCloseApp();

            //初始化
            lifeActivityCount = 0;
            isAppBack = false;
            activityList.clear();
        }
    }

    /**
     * 应用首次启动的时候调用
     */
    protected abstract void onAppLaunch(boolean isColdLaunch);

    /**
     * 切换至后台时调用
     */
    protected abstract void onSwitchBack();

    /**
     * 从后台切换至前台时调用
     */
    protected abstract void onSwitchFront();

    /**
     * 关闭应用时回调
     */
    protected abstract void onCloseApp();

    public void quitApp() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }
}
