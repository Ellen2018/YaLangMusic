package com.ellen.javabase.simpleapi.NetListener;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.ellen.javabase.simpleapi.broadcast.SystemBroadcastManager;

import java.lang.ref.WeakReference;

/**
 * 网络状态监听
 * FragmentActivity下可进行无痕迹注销
 */
public class NetManager {

    private NetListener netListener;
    private WeakReference<Activity> fragmentActivityWeakReference;
    private final String NET_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    private SystemBroadcastManager systemBroadcastManager;
    private NetBroadcastReceiver netBroadcastReceiver;

    public NetManager(Activity activity,NetListener netListener){
        this.setNetListener(netListener);
        fragmentActivityWeakReference = new WeakReference<>(activity);
        //注册广播
        systemBroadcastManager = new SystemBroadcastManager(activity);
        netBroadcastReceiver = new NetBroadcastReceiver();
        netBroadcastReceiver.setChangeListener(new NetBroadcastReceiver.ChangeListener() {
            @Override
            public void change() {
                netStatus(fragmentActivityWeakReference.get());
            }
        });
        systemBroadcastManager.register(NET_ACTION,netBroadcastReceiver);
    }

    public void cancel(){
        if(systemBroadcastManager != null){
            systemBroadcastManager.unRegister(NET_ACTION,netBroadcastReceiver);
        }
    }

    public void setNetListener(NetListener netListener) {
        this.netListener = netListener;
    }

    public void netStatus(Context context){
        //得到连接管理器对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = null;
        //因为市场上普遍都是5.0以上的系统，所以这里无须做api适配
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }else {
            //如果有特殊机型版本小于5.0，那么这里需要做api适配去获取网络状态
        }
        //如果网络连接，判断该网络类型
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
               //wifi模式
                if(netListener != null){
                    netListener.wifiStatus();
                }
            } else if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
               //流量模式
                if(netListener != null){
                    netListener.flowStatus();
                }
            }
        } else {
            //网络异常
            if(netListener != null){
                netListener.noNetStatus();
            }
        }
    }

}
