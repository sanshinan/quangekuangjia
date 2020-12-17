package com.example.day02_zy.ui;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.day02_zy.R;
import com.example.day02_zy.base.BaseActivity;
import com.example.day02_zy.bean.Banbean;
import com.example.day02_zy.bean.Cjbean;
import com.example.day02_zy.bean.Xwbean;
import com.example.day02_zy.net.FInd;
import com.example.day02_zy.persent.JYPersenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity<JYPersenter> implements FInd.View {

    private TabLayout tab;
    private Banner ban;
    private ViewPager vp;
    List<Banbean.BannerlistBean> bann;
    String[] tabs={"学校新闻","班级成绩查询"};
    List<Fragment> fragments;
    @Override
    protected int getLayout() {
        return R.layout.activity_jy;
    }

    @Override
    protected void initView() {
        ban = findViewById(R.id.ban);
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);
        bann=new ArrayList<>();

        //gragment 集合
        fragments=new ArrayList<>();

        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(myAdapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    protected JYPersenter createPersenter() {
        return new JYPersenter(this);
    }

    @Override
    protected void initData() {
        persenter.getbanne();
    }

    @Override
    public void getban(Banbean banbean) {
        bann.clear();
        bann.addAll(banbean.getBannerlist());
        Log.i("TAG", "getban: "+banbean.toString());
        ban.setImages(bann)
                .setBannerAnimation(Transformer.ForegroundToBackground)
                .setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Banbean.BannerlistBean oo= (Banbean.BannerlistBean) path;
                Glide.with(context).load(oo.getImageurl()).into(imageView);
            }
        }).start();
    }

    @Override
    public void getxw(Xwbean xwbean) {

    }

    @Override
    public void getcj(Cjbean cjbean) {

    }
    //viewpage的适配器
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
