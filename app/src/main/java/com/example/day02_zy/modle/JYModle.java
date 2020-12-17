package com.example.day02_zy.modle;

import com.example.day02_zy.base.BaseModel;
import com.example.day02_zy.bean.Banbean;
import com.example.day02_zy.bean.Cjbean;
import com.example.day02_zy.bean.Xwbean;
import com.example.day02_zy.initface.Callback;
import com.example.day02_zy.net.CommonSubscriber;
import com.example.day02_zy.net.FInd;
import com.example.day02_zy.net.HttpManager;
import com.example.day02_zy.utils.RxUtils;

public class JYModle extends BaseModel implements FInd.Model{

    @Override
    public void getb(Callback callback) {
            addDisposable(
                    HttpManager.getInstance().getPushServic().getban()
                    .compose(RxUtils.rxScheduler())
                    .subscribeWith(new CommonSubscriber<Banbean>(callback) {
                        @Override
                        public void onNext(Banbean banbean) {
                            callback.success(banbean);
                        }
                    })
            );
    }

    @Override
    public void getx(Callback callback) {
        addDisposable(
                HttpManager.getInstance().getPushServic().getxinwen()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<Xwbean>(callback) {
                            @Override
                            public void onNext(Xwbean xwbean) {
                                callback.success(xwbean);
                            }
                        })
        );
    }

    @Override
    public void getc(Callback callback) {
            addDisposable(
                    HttpManager.getInstance().getPushServic().getcj()
                    .compose(RxUtils.rxScheduler())
                    .subscribeWith(new CommonSubscriber<Cjbean>(callback) {
                        @Override
                        public void onNext(Cjbean cjbean) {
                            callback.success(cjbean);
                        }
                    })
            );
    }
}
