package com.ellen.javabase.simpleapi.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;

import androidx.fragment.app.FragmentActivity;

import com.ellen.javabase.simpleapi.ActivityLifeListener.ActivityLifeListener;
import com.ellen.javabase.simpleapi.ActivityLifeListener.ActivityLifeListenerManager;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 简化广播注册代码
 * 无需进行广播注销，无侵入式注销
 */
public class SystemBroadcastManager {

    private Map<String, IntentFilter> intentFilterMap;
    private WeakReference<Activity> activityWeakReference;
    private Map<String, BroadcastReceiver> broadcastReceiverMap;
    private ActivityLifeListenerManager activityLifeListenerManager;

    public SystemBroadcastManager(Activity activity){
        activityWeakReference = new WeakReference<>(activity);
        //仅仅Activity继承于FragmentActivity才能机进行无痕迹注销
        //否则你只能手动注销
        if(activity instanceof FragmentActivity) {
            activityLifeListenerManager = new ActivityLifeListenerManager();
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            activityLifeListenerManager.startActivityLifeListener(fragmentActivity, new ActivityLifeListener() {
                @Override
                public void onStart() {

                }

                @Override
                public void onStop() {

                }

                @Override
                public void onDestroy() {
                    //注销
                    Set<String> set = broadcastReceiverMap.keySet();
                    for (String action : set) {
                        unRegister(action, broadcastReceiverMap.get(action));
                    }
                }

                @Override
                public void onResume() {

                }
            });
        }
    }

    public void register(String action,BroadcastReceiver broadcastReceiver){
        if(intentFilterMap == null){
            intentFilterMap = new HashMap<>();
        }
        if(broadcastReceiverMap == null){
            broadcastReceiverMap = new HashMap<>();
        }
        registerBroadcast(action,broadcastReceiver);
    }

    public void unRegister(String action,BroadcastReceiver broadcastReceiver){
        unRegisterBroadcast(action,broadcastReceiver);
    }

    private void registerBroadcast(String action,BroadcastReceiver broadcastReceiver){
        IntentFilter intentFilter = new IntentFilter(action);
        intentFilterMap.put(action,intentFilter);
        broadcastReceiverMap.put(action,broadcastReceiver);
        activityWeakReference.get().registerReceiver(broadcastReceiver,intentFilter);
    }

    private void unRegisterBroadcast(String action,BroadcastReceiver broadcastReceiver){
        intentFilterMap.remove(action);
        intentFilterMap.remove(action);
        activityWeakReference.get().unregisterReceiver(broadcastReceiver);
    }

}
