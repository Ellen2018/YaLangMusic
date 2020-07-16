package com.ellen.javabase.loading;

public class ShowBean {

    private boolean isShowContent;
    private boolean isShowEmpty;
    private boolean isShowLoading;
    private boolean isShowFailure;

    public boolean isShowContent() {
        return isShowContent;
    }

    public void setShowContent(boolean showContent) {
        isShowContent = showContent;
    }

    public boolean isShowEmpty() {
        return isShowEmpty;
    }

    public void setShowEmpty(boolean showEmpty) {
        isShowEmpty = showEmpty;
    }

    public boolean isShowLoading() {
        return isShowLoading;
    }

    public void setShowLoading(boolean showLoading) {
        isShowLoading = showLoading;
    }

    public boolean isShowFailure() {
        return isShowFailure;
    }

    public void setShowFailure(boolean showFailure) {
        isShowFailure = showFailure;
    }
}
