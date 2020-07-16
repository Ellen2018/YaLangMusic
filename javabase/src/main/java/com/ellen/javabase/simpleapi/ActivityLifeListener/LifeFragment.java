package com.ellen.javabase.simpleapi.ActivityLifeListener;


import androidx.fragment.app.Fragment;

public class LifeFragment extends Fragment {

    private ActivityLifeListener activityLifeListener;

    public void setActivityLifeListener(ActivityLifeListener activityLifeListener) {
        this.activityLifeListener = activityLifeListener;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(activityLifeListener != null){
            activityLifeListener.onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(activityLifeListener != null){
            activityLifeListener.onStop();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(activityLifeListener != null){
            activityLifeListener.onResume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(activityLifeListener != null){
            activityLifeListener.onDestroy();
        }
    }
}
