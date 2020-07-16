package com.ellen.javabase.datachange;

public interface DataChangeListener<T> {
    void change(T t);
}
