package com.example.day02_zy.persent;

import com.example.day02_zy.base.BasePersenter;
import com.example.day02_zy.bean.Banbean;
import com.example.day02_zy.bean.Cjbean;
import com.example.day02_zy.bean.Xwbean;
import com.example.day02_zy.initface.Callback;
import com.example.day02_zy.modle.JYModle;
import com.example.day02_zy.net.FInd;

public class JYPersenter extends BasePersenter<FInd.View> implements FInd.Persent {
    FInd.View view;
    FInd.Model model;

    public JYPersenter(FInd.View view){
        this.view=view;
        this.model=new JYModle();
    }
    @Override
    public void getbanne() {
        this.model.getb(new Callback() {
            @Override
            public void fail(String msg) {
                if (view!=null){
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view!=null){
                    view.getban((Banbean) o);
                }
            }
        });
    }

    @Override
    public void getxinwen() {
        this.model.getx(new Callback() {
            @Override
            public void fail(String msg) {
                if (view!=null){
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view!=null){
                    view.getxw((Xwbean) o);
                }
            }
        });
    }

    @Override
    public void getcehgnji() {
            this.model.getc(new Callback() {
                @Override
                public void fail(String msg) {
                    if (view!=null){
                        view.tips(msg);
                    }
                }

                @Override
                public void success(Object o) {
                    if (view!=null){
                        view.getcj((Cjbean) o);
                    }
                }
            });
    }
}
