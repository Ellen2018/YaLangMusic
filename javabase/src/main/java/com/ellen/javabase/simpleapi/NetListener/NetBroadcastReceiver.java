package com.ellen.javabase.simpleapi.NetListener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class NetBroadcastReceiver extends BroadcastReceiver {

    private ChangeListener changeListener;

    public void setChangeListener(ChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
       if(changeListener != null){
           changeListener.change();
       }
    }

    interface ChangeListener{
        void change();
    }
}
