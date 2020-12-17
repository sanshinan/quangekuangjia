package com.example.day02_zy.ui;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02_zy.R;
import com.example.day02_zy.base.BaseFragment;
import com.example.day02_zy.bean.Banbean;
import com.example.day02_zy.bean.Cjbean;
import com.example.day02_zy.bean.Xwbean;
import com.example.day02_zy.net.FInd;
import com.example.day02_zy.persent.JYPersenter;
import com.example.day02_zy.ui.adapter.XinAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OneFragment extends BaseFragment<JYPersenter> implements FInd.View {

    @BindView(R.id.recy_a)
    RecyclerView recyA;
    List<Xwbean.NewsBean> beans;
    private XinAdapter xinAdapter;

    @Override
    public int getLayout() {
        return R.layout.fragment_a;
    }

    @Override
    public void initView() {
        beans=new ArrayList<>();
        xinAdapter = new XinAdapter(getContext(), beans);
        recyA.setLayoutManager(new LinearLayoutManager(getContext()));
        recyA.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));
        recyA.setAdapter(xinAdapter);

    }

    @Override
    public JYPersenter createPersenter() {
        return new JYPersenter(this);
    }

    @Override
    public void initData() {
    persenter.getxinwen();
    }

    @Override
    public void getban(Banbean banbean) {

    }

    @Override
    public void getxw(Xwbean xwbean) {
        beans.clear();
        beans.addAll(xwbean.getNews());
        xinAdapter.notifyDataSetChanged();
    }

    @Override
    public void getcj(Cjbean cjbean) {

    }
}
