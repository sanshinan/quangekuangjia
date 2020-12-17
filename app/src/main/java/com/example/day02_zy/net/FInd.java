package com.example.day02_zy.net;

import com.example.day02_zy.bean.Banbean;
import com.example.day02_zy.bean.Cjbean;
import com.example.day02_zy.bean.Xwbean;
import com.example.day02_zy.initface.Callback;
import com.example.day02_zy.initface.IBasePersenter;
import com.example.day02_zy.initface.IBaseView;
import com.example.day02_zy.initface.IModel;

public interface FInd {
    //发现业务
    interface View extends IBaseView {
        //banner
        void getban(Banbean banbean);
        //新闻
        void getxw(Xwbean xwbean);
        //成绩
        void getcj(Cjbean cjbean);
    }

    interface Persent extends IBasePersenter<View> {
        void getbanne();
        //re点
        void getxinwen();
        void getcehgnji();
    }

    interface Model extends IModel {
        void getb(Callback callback);

        void getx(Callback callback);

        void getc(Callback callback);
    }
}
