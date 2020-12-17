package com.example.day02_zy.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day02_zy.R;
import com.example.day02_zy.base.BaseAdapter;
import com.example.day02_zy.bean.Xwbean;

import java.util.List;

public class XinAdapter extends BaseAdapter {
    Context context;
    public XinAdapter(Context context, List datas) {
        super(context, datas);
        this.context=context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_a;
    }

    @Override
    protected void Data(Object data, VH vh) {
        Xwbean.NewsBean datas= (Xwbean.NewsBean) data;
        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        TextView texta = (TextView) vh.getViewByid(R.id.texta);
        TextView textb = (TextView) vh.getViewByid(R.id.textb);
        Glide.with(context).load(datas.getImageUrl()).into(img);
        texta.setText(datas.getTile());
        textb.setText(datas.getContent());
    }
}
