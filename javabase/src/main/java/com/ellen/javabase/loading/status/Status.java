package com.ellen.javabase.loading.status;

/**
 * 状态
 */
public class Status{
    /**
     * 状态值
     */
    private int statusCode;

    public StatusUpdate statusUpdate;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusUpdate(StatusUpdate statusUpdate) {
        this.statusUpdate = statusUpdate;
    }


    void active() {
        if (statusUpdate != null) {
            statusUpdate.active(this);
        }
    }

    void deActive() {
        if (statusUpdate != null) {
            statusUpdate.deActive(this);
        }
    }
}
