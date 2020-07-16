package com.ellen.javabase.simpleapi.NetListener;

public interface NetListener {

    /**
     * WiFi状态
     */
    void wifiStatus();

    /**
     * 流量状态
     */
    void flowStatus();


    /**
     * 无网络状态
     */
    void noNetStatus();
}
