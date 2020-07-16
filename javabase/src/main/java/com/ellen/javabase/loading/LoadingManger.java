package com.ellen.javabase.loading;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.lang.ref.WeakReference;

/**
 * Loading机制
 * 加载视图
 * 空视图
 * 内容视图
 * 失败视图
 * 四者之间的隐藏关系 & Ui更新逻辑的封装
 */
public class LoadingManger {

    private View loadingView;
    private View contentView;
    private View emptyView;
    private View failureView;
    private View parentView;
    private WeakReference<Activity> activityWeakReference;
    private LoadingCallback loadingCallback;

    private void init(Activity activity,View contentView,View emptyView,View loadingView,View failureView){
        activityWeakReference = new WeakReference<>(activity);
        this.contentView = contentView;
        this.emptyView = emptyView;
        this.loadingView = loadingView;
        this.failureView = failureView;
    }

    private void init(Activity activity, View parentView, int emptyLayoutId, int loadingLayoutId, int contentLayoutId, int failureLayoutId) {
        activityWeakReference = new WeakReference<>(activity);
        if (parentView != null) {
            this.parentView = parentView;
        }
        layoutInflater(emptyLayoutId, loadingLayoutId, contentLayoutId, failureLayoutId);
        addView();
    }

    public LoadingManger(Activity activity,View contentView,View emptyView){
        init(activity,contentView,emptyView,null,null);
    }

    public LoadingManger(Activity activity,View contentView,View emptyView,View loadingView,View failureView){
        init(activity,contentView,emptyView,loadingView,failureView);
    }

    /**
     * 无parentView场景
     *
     * @param activity
     * @param emptyLayoutId
     * @param loadingLayoutId
     * @param contentLayoutId
     */
    public LoadingManger(Activity activity, int emptyLayoutId, int loadingLayoutId, int contentLayoutId, int failureLayoutId) {
        init(activity, null, emptyLayoutId, loadingLayoutId, contentLayoutId, failureLayoutId);
    }

    /**
     * @param activity
     * @param emptyLayoutId
     * @param contentLayoutId
     */
    public LoadingManger(Activity activity, int emptyLayoutId, int contentLayoutId) {
        init(activity, null, emptyLayoutId, -1, contentLayoutId, -1);
    }

    /**
     * 有parentView场景
     *
     * @param activity
     * @param emptyLayoutId
     * @param loadingLayoutId
     * @param contentLayoutId
     */
    public LoadingManger(Activity activity, FrameLayout parentView, int emptyLayoutId, int loadingLayoutId, int contentLayoutId, int failureLayoutId) {
        init(activity, parentView, emptyLayoutId, loadingLayoutId, contentLayoutId, failureLayoutId);
    }

    /**
     * 有parentView场景
     *
     * @param activity
     * @param emptyLayoutId
     * @param loadingLayoutId
     * @param contentLayoutId
     */
    public LoadingManger(Activity activity, RelativeLayout parentView, int emptyLayoutId, int loadingLayoutId, int contentLayoutId, int failureLayoutId) {
        init(activity, parentView, emptyLayoutId, loadingLayoutId, contentLayoutId, failureLayoutId);
    }

    /**
     * 有parentView场景
     *
     * @param activity
     * @param emptyLayoutId
     * @param contentLayoutId
     */
    public LoadingManger(Activity activity, RelativeLayout parentView, int emptyLayoutId, int contentLayoutId) {
        init(activity, parentView, emptyLayoutId, -1, contentLayoutId, -1);
    }


    private void layoutInflater(int emptyLayoutId, int loadingLayoutId, int contentLayoutId, int failureLayoutId) {
        if (contentLayoutId != -1) {
            contentView = getViewByLayoutId(contentLayoutId);
        }
        if (emptyLayoutId != -1) {
            emptyView = getViewByLayoutId(emptyLayoutId);
        }
        if (loadingLayoutId != -1) {
            loadingView = getViewByLayoutId(loadingLayoutId);
        }
        if (failureLayoutId != -1) {
            failureView = getViewByLayoutId(failureLayoutId);
        }
    }

    private void addView() {
        if (parentView == null) {
            parentView = new FrameLayout(getContext());
        }
        if (parentView instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parentView;
            if (emptyView != null) {
                frameLayout.addView(emptyView);
            }
            if (contentView != null) {
                frameLayout.addView(contentView);
            }
            if (loadingView != null) {
                frameLayout.addView(loadingView);
            }
            if (failureView != null) {
                frameLayout.addView(failureView);
            }
        }
        if (parentView instanceof RelativeLayout) {
            RelativeLayout relativeLayout = (RelativeLayout) parentView;
            if (emptyView != null) {
                relativeLayout.addView(emptyView);
            }
            if (contentView != null) {
                relativeLayout.addView(contentView);
            }
            if (loadingView != null) {
                relativeLayout.addView(loadingView);
            }
            if (failureView != null) {
                relativeLayout.addView(failureView);
            }
        }
    }

    public void setLoadingCallback(LoadingCallback loadingCallback) {
        this.loadingCallback = loadingCallback;
    }

    public <T extends View> T findViewByLoading(int id) {
        return loadingView.findViewById(id);
    }

    public <T extends View> T findViewByContent(int id) {
        return contentView.findViewById(id);
    }

    public <T extends View> T findViewByEmpty(int id) {
        return emptyView.findViewById(id);
    }

    public <T extends View> T findViewByFailure(int id) {
        return failureView.findViewById(id);
    }

    public Activity getActivity() {
        return activityWeakReference.get();
    }

    public Context getContext() {
        return activityWeakReference.get();
    }

    private View getViewByLayoutId(int layoutId) {
        View view = LayoutInflater.from(getContext()).inflate(layoutId, null);
        return view;
    }

    public View getParentView() {
        return parentView;
    }

    private void updateUi() {
        if (loadingCallback == null) return;
        boolean content = false, empty = false, loading = false, failure = false;
        if (contentView != null && contentView.getVisibility() == View.VISIBLE) {
            content = true;
        }
        if (emptyView != null && emptyView.getVisibility() == View.VISIBLE) {
            empty = true;
        }
        if (loadingView != null && loadingView.getVisibility() == View.VISIBLE) {
            loading = true;
        }
        if (failureView != null && failureView.getVisibility() == View.VISIBLE) {
            failure = true;
        }
        ShowBean showBean = new ShowBean();
        showBean.setShowContent(content);
        showBean.setShowEmpty(empty);
        showBean.setShowLoading(loading);
        showBean.setShowFailure(failure);
        loadingCallback.show(showBean);
    }

    public void showByYouSelf(boolean isShowContent, boolean isShowEmpty, boolean isShowLoading, boolean isShowFailure) {
        show(isShowContent, isShowEmpty, isShowLoading, isShowFailure);
    }

    public void showEmpty() {
        show(false, true, false, false);
    }

    public void showLoading() {
        show(false, false, true, false);
    }

    public void showContent() {
        show(true, false, false, false);
    }

    public void showFailure() {
        show(false, false, false, true);
    }

    private void show(boolean isShowContent, boolean isShowEmpty, boolean isShowLoading, boolean isShowFailure) {
        if (contentView != null) {
            if (isShowContent) {
                contentView.setVisibility(View.VISIBLE);
            } else {
                contentView.setVisibility(View.GONE);
            }
        }
        if (emptyView != null) {
            if (isShowEmpty) {
                emptyView.setVisibility(View.VISIBLE);
            } else {
                emptyView.setVisibility(View.GONE);
            }
        }
        if (loadingView != null) {
            if (isShowLoading) {
                loadingView.setVisibility(View.VISIBLE);
            } else {
                loadingView.setVisibility(View.GONE);
            }
        }
        if (failureView != null) {
            if (isShowFailure) {
                failureView.setVisibility(View.VISIBLE);
            } else {
                failureView.setVisibility(View.GONE);
            }
        }
        updateUi();
    }

}
