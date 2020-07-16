package com.ellen.javabase.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    protected View mContentView;
    protected boolean isVisibleToUser = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(setLayout(), container, false);
        if(this instanceof BaseRegister){
            BaseRegister baseRegister = (BaseRegister) this;
            baseRegister.register(mContentView);
        }
        initView();
        initData();
        return mContentView;
    }

    protected <T extends View> T findViewById(int id){
        View view = mContentView.findViewById(id);
        return (T) view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(this instanceof BaseRegister){
            BaseRegister baseRegister = (BaseRegister) this;
            baseRegister.unRegister(mContentView);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisibleToUser = isVisibleToUser;
        if(isVisibleToUser){
            if(this instanceof LazyLoadInterface){
                LazyLoadInterface lazyLoadInterface = (LazyLoadInterface) this;
                lazyLoadInterface.lazyLoad();
            }
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    protected abstract void initData();
    protected abstract void initView();
    protected abstract int setLayout();

    public interface LazyLoadInterface{
        void lazyLoad();
    }
}
