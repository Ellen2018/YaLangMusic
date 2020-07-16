package com.ellen.javabase.loading.status;

import java.util.ArrayList;
import java.util.List;

/**
 * Loading机制状态管理类
 * 能清晰管理UI界面的状态,代码质量维护性等等破有好处
 */
public class StatusManager implements StatusSetting {

    private List<Status> statusList;
    private Status currentStatus;
    private StatusChangeListener statusChangeListener;

    public void setStatusChangeListener(StatusChangeListener statusChangeListener) {
        this.statusChangeListener = statusChangeListener;
    }

    @Override
    public void addStatus(Status status) {
        if (statusList == null) {
            statusList = new ArrayList<>();
        }
        statusList.add(status);
    }

    @Override
    public void addStatus(List<Status> statuses) {
        for (Status status : statuses) {
            addStatus(status);
        }
    }

    @Override
    public void removeStatus(Status status) {
        statusList.remove(status);
    }

    @Override
    public void submitStatus(Status status) {
        if (!statusList.contains(status)) {
            return;
        }
        if (currentStatus == null) {
            currentStatus = status;
            statusActive(null, currentStatus);
        } else {
            Status oldStatus = currentStatus;
            currentStatus = status;
            statusActive(oldStatus, currentStatus);
        }
    }

    @Override
    public List<Status> getAllStatus() {
        return statusList;
    }

    private void statusActive(Status oldStatus, Status newStatus) {
        if (statusChangeListener != null) {
            statusChangeListener.statusChange(oldStatus, newStatus);
        } else {
            if (oldStatus != null) {
                oldStatus.deActive();
            }
            newStatus.active();
        }
    }

    @Override
    public void cancel() {
        if (statusChangeListener != null) {
            statusChangeListener.cancel();
        } else {
            if (currentStatus != null) {
                currentStatus.deActive();
            }
        }
    }
}
