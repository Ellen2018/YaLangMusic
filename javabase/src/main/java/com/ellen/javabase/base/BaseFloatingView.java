package com.ellen.javabase.base;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import java.lang.ref.WeakReference;

/**
 *
 * 悬浮View封装
 *
 */
public abstract class BaseFloatingView {
    private WindowManager windowManager;
    private View mContentView;
    private WeakReference<Activity> activityWeakReference;
    private WindowManager.LayoutParams layoutParams;
    private boolean isFirstAdd = false;
    private View.OnTouchListener onTouchListener;

    public BaseFloatingView(Activity activity){
        activityWeakReference = new WeakReference<>(activity);
        windowManager = (WindowManager) activity.getApplication().getSystemService(Context.WINDOW_SERVICE);
        //1.创建一个Layoutparams出来
        layoutParams = new WindowManager.LayoutParams();
        setLayoutParams(layoutParams);
        //2.布局映射一个View对象出来
        LayoutInflater inflater;
        inflater = LayoutInflater.from(activity.getApplication());
        mContentView = getFloatingView(inflater);
        if(this instanceof BaseRegister){
            BaseRegister baseRegister = (BaseRegister) this;
            baseRegister.register(mContentView);
        }
        //初始化view对象，可以绑定控件
        initView();
        initData();
    }

    protected <T extends View> T findViewById(int id){
        return mContentView.findViewById(id);
    }

    public View.OnTouchListener getOnTouchListener() {
        return onTouchListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    public boolean isFirstAdd() {
        return isFirstAdd;
    }

    public boolean isShow(){
        return mContentView.getVisibility() == View.VISIBLE;
    }

    public void createAndShow(){
        if(onTouchListener != null){
            mContentView.setOnTouchListener(onTouchListener);
        }
        windowManager.addView(mContentView,layoutParams);
        isFirstAdd = true;
    }

    public void hide(){
        mContentView.setVisibility(View.GONE);
    }

    public void show(){
        mContentView.setVisibility(View.VISIBLE);
    }

    public void cancel(){
        if(this instanceof BaseRegister){
            BaseRegister baseRegister = (BaseRegister) this;
            baseRegister.unRegister(mContentView);
        }
        windowManager.removeView(mContentView);
    }

    public Activity getActivity(){
        return activityWeakReference.get();
    }

    public Context getContext(){
        return activityWeakReference.get();
    }

    protected abstract void initView();
    protected abstract void initData();
    protected abstract void setLayoutParams(WindowManager.LayoutParams layoutParams);
    protected abstract View getFloatingView(LayoutInflater inflater);

}

