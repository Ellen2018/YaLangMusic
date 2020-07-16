package com.ellen.javabase.datachange;

/**
 * 数据改变监听事件
 * 利用动态代理进行变化监听
 *
 * 无论是动态代理还是回调都解决不了对一个类的数据变化监听
 *  student.age = 3; -->这种代码不会回调任何函数，因此回调和动态监听机制会失效
 */
public class DataChangeManager<T> {

    private T data;
    private DataChangeListener<T> dataChangeListener;

    public void setData(T data,DataChangeListener<T> dataChangeListener){
        this.data = data;
        this.dataChangeListener = dataChangeListener;
    }



}
