package com.ellen.javabase.base;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

/**
 * 自定义Toast基类，可支持任意的布局
 */
public abstract class BaseToast {

    private WeakReference<AppCompatActivity> activityWeakReference;
    private Toast toast;
    private View mContentView;

    public BaseToast(AppCompatActivity activity){
        activityWeakReference = new WeakReference<>(activity);
        init();
    }

    protected <T extends View> T findViewById(int id){
        return mContentView.findViewById(id);
    }

    private void init() {
        mContentView = onCreateView();
        initView();
        initData();
        toast = new Toast(activityWeakReference.get());
        setToastGravity(toast);
        toast.setDuration(getDuration());
        toast.setView(mContentView);
    }

    protected abstract View onCreateView();

    public void show(){
        toast.show();
    }

    public Context getContext(){
        return activityWeakReference.get();
    }

    protected abstract int getDuration();
    protected abstract void setToastGravity(Toast toast);
    protected abstract void initView();
    protected abstract void initData();

}
