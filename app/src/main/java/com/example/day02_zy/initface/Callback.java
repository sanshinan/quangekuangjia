package com.example.day02_zy.initface;

public interface Callback<T> {

    void fail(String msg);

    void success(T t);

}
