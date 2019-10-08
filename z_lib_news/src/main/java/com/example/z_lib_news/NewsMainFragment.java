package com.example.z_lib_news;


import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseFragment;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/9/25 17:09
 */
@Route(path = ARouterUtils.NEWS_MAIN_FRAGMENT)
public class NewsMainFragment extends BaseFragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NewsMainFragment.
     */
    public static NewsMainFragment newInstance() {
        return new NewsMainFragment();
    }



    public NewsMainFragment() {
        // Required empty public constructor
    }


    @Override
    protected int setLayoutId() {
        return R.layout.news_fragment_main_news;
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
    }

    @Override
    protected void initData() {
        super.initData();
    }

}














