package com.ellen.javabase.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;

import java.lang.ref.WeakReference;

public abstract class BaseDialog {

    private AlertDialog dialog;
    private WeakReference<Activity> activityWeakReference;
    private OnDismissListener onDismissListener;
    private View mContentView;

    public BaseDialog(Activity activity) {
        activityWeakReference = new WeakReference<>(activity);
        init();
    }

    protected String getTag() {
        return getClass().getSimpleName();
    }

    private void init() {
        dialog = new AlertDialog.Builder(activityWeakReference.get()).create();
        mContentView = onCreateView();
        //设置布局
        dialog.setView(mContentView);
        if (this instanceof BaseRegister) {
           BaseRegister baseRegister = (BaseRegister) this;
           baseRegister.register(mContentView);
        }
        if (setCancelable() != null) {
            dialog.setCancelable(setCancelable());
        }
        if (setCanceledOnTouchOutside() != null) {
            dialog.setCanceledOnTouchOutside(setCanceledOnTouchOutside());
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (onDismissListener != null) {
                    onDismissListener.dismiss();
                }
            }
        });
    }

    public void show() {
        showBefore();
        if (isTypeToast() != null && isTypeToast()) {
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        }
        dialog.show();
        onResume();
    }

    protected <T extends View> T findViewById(int id){
        return mContentView.findViewById(id);
    }

    public void dismiss() {
        dismissBefore();
        if (this instanceof BaseRegister) {
           BaseRegister baseRegister = (BaseRegister) this;
           baseRegister.unRegister(mContentView);
        }
        dialog.dismiss();
        destory();
    }

    public Activity getActivity() {
        return activityWeakReference.get();
    }

    public Context getContext() {
        return activityWeakReference.get();
    }

    public OnDismissListener getOnDismissListener() {
        return onDismissListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    protected abstract View onCreateView();
    protected abstract void showBefore();
    protected abstract void onResume();
    protected abstract void dismissBefore();
    protected abstract void destory();
    protected abstract Boolean setCancelable();
    protected abstract Boolean setCanceledOnTouchOutside();

    public interface OnDismissListener {
        void dismiss();
    }

    protected Boolean isTypeToast() {
        return null;
    }
}
