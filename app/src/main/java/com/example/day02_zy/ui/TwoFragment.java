package com.example.day02_zy.ui;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02_zy.R;
import com.example.day02_zy.base.BaseAdapter;
import com.example.day02_zy.base.BaseFragment;
import com.example.day02_zy.bean.Banbean;
import com.example.day02_zy.bean.Cjbean;
import com.example.day02_zy.bean.Xwbean;
import com.example.day02_zy.net.FInd;
import com.example.day02_zy.persent.JYPersenter;
import com.example.day02_zy.ui.adapter.CjAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TwoFragment extends BaseFragment<JYPersenter> implements FInd.View {

    @BindView(R.id.recy_b)
    RecyclerView recyb;

    List<Cjbean.StudenlistBean> beans;
    private CjAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.fragment_b;
    }

    @Override
    public void initView() {
        beans=new ArrayList<>();
        adapter = new CjAdapter(getContext(), beans);
        recyb.setLayoutManager(new LinearLayoutManager(getContext()));
        recyb.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));
        recyb.setAdapter(adapter);

        adapter.setIlistClick(new BaseAdapter.IlistClick() {
            @Override
            public void item(int pos) {
                beans.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public JYPersenter createPersenter() {
        return new JYPersenter(this);
    }

    @Override
    public void initData() {
        persenter.getcehgnji();
    }

    @Override
    public void getban(Banbean banbean) {

    }

    @Override
    public void getxw(Xwbean xwbean) {

    }

    @Override
    public void getcj(Cjbean cjbean) {
            beans.clear();
            beans.addAll(cjbean.getStudenlist());
            adapter.notifyDataSetChanged();
    }
}
