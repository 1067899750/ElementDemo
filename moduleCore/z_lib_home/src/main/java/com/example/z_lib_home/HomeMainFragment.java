package com.example.z_lib_home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_base.arouter.ARouterManager;
import com.example.z_lib_base.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_home.glide.SimpleActivity;
import com.example.z_lib_home.glide.ViewpagerActivity;


/**
 * @author puyantao
 * @description 首页
 * @date 2019/9/25 16:42
 */
@Route(path = ARouterUtils.HOME_MAIN_FRAGMENT)
public class HomeMainFragment extends BaseFragment implements View.OnClickListener {

    public HomeMainFragment() {
        // Required empty public constructor
    }

    public static HomeMainFragment newInstance() {
        HomeMainFragment fragment = new HomeMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.home_fragment_home_main;
    }

    @Override
    protected void initViews(View view) {
        view.findViewById(R.id.news_button).setOnClickListener(this);
        view.findViewById(R.id.girls_button).setOnClickListener(this);
        view.findViewById(R.id.fragment_button).setOnClickListener(this);
        view.findViewById(R.id.glide_button1).setOnClickListener(this);
        view.findViewById(R.id.glide_button2).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.news_button) {
            //跳转到NewsCenterActivity
            ARouterManager.startNewsCanterActivity();

        } else if (i == R.id.girls_button) {
            //跳转到GirlsActivity
            ARouterManager.startGrilsListActivity();

        } else if (i == R.id.fragment_button) {
            startActivity(new Intent(getContext(), BottomNavigationActivity.class));

        } else if (i == R.id.glide_button1) {
            //加载图片
            startActivity(new Intent(getContext(), ViewpagerActivity.class));

        } else if (i == R.id.glide_button2) {
            //加载图片
            startActivity(new Intent(getContext(), SimpleActivity.class));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
















