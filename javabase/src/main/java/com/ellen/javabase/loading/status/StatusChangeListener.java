package com.ellen.javabase.loading.status;

public interface StatusChangeListener {

    void statusChange(Status oldStatus, Status newStatus);
    void cancel();

}
