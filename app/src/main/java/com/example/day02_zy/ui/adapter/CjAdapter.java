package com.example.day02_zy.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.day02_zy.R;
import com.example.day02_zy.base.BaseAdapter;
import com.example.day02_zy.bean.Cjbean;

import java.util.List;

public class CjAdapter extends BaseAdapter {

    public CjAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_b;
    }

    @Override
    protected void Data(Object data, VH vh) {
        Cjbean.StudenlistBean datas= (Cjbean.StudenlistBean) data;
        TextView titlea = (TextView) vh.getViewByid(R.id.titlea);
        TextView titleb = (TextView) vh.getViewByid(R.id.titleb);
        TextView titlec = (TextView) vh.getViewByid(R.id.titlec);
        titlea.setText("姓名："+datas.getName());
        titleb.setText("技能成绩："+datas.getSkill());
        titlec.setText("理论成绩："+datas.getTheory());
    }
}
