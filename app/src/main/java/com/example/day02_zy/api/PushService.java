package com.example.day02_zy.api;

import com.example.day02_zy.bean.Banbean;
import com.example.day02_zy.bean.Cjbean;
import com.example.day02_zy.bean.Xwbean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface PushService {
    String url="http://cdwan.cn:7000/";
    String xw="http://cdwan.cn:7000/";
    String cj="http://cdwan.cn:7000/";

    @GET("exam2003/abannerlist.json")
    Flowable<Banbean> getban();

    @GET("exam2003/anewslist.json")
    Flowable<Xwbean> getxinwen();

    @GET("exam2003/astudent.json")
    Flowable<Cjbean> getcj();


}
