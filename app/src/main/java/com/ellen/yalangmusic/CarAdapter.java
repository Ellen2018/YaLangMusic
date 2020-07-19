package com.ellen.yalangmusic;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.ellen.javabase.adapter.recyclerview.BaseSingleRecyclerViewAdapter;
import com.ellen.javabase.adapter.recyclerview.BaseViewHolder;

import java.util.List;

public class CarAdapter extends BaseSingleRecyclerViewAdapter<String, CarAdapter.MyViewHolder> {

    public CarAdapter(Context context, List<String> dataList) {
        super(context, dataList);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_test;
    }

    @Override
    protected MyViewHolder getNewViewHolder(View view) {
        return new MyViewHolder(view);
    }

    @Override
    protected void showData(MyViewHolder myViewHolder, String data, int position) {

    }

    static class MyViewHolder extends BaseViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
