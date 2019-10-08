package com.example.z_lib_news;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.arouter.ARouterManager;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseFragment;


/**
 * @author puyantao
 * @description
 * @date 2019/9/25 17:09
 */
@Route(path = ARouterUtils.NEWS_MAIN_FRAGMENT)
public class NewsMainFragment extends BaseFragment {
    private Button newsBtn;

    public NewsMainFragment() {
    }


    public static NewsMainFragment newInstance() {
        NewsMainFragment fragment = new NewsMainFragment();
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
        return R.layout.news_fragment_main_news;
    }

    @Override
    protected void initViews(View view) {
        newsBtn = view.findViewById(R.id.news_btn);
        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouterManager.startNewsCanterActivity();
            }
        });
    }

    @Override
    protected void initData() {

    }

}














