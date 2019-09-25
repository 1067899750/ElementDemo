package com.example.z_lib_news;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.news_fragment_main_news, container, false);
    }


}
