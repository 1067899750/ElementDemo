package com.example.z_lib_news.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_news.R;

import java.util.ArrayList;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/5 17:12
 */
public class HomeChildFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private HomeChildAdapter mTableChildAdapter;
    private ArrayList<String> mDates;


    public HomeChildFragment() {
        // Required empty public constructor
    }


    public static HomeChildFragment newInstance() {
        HomeChildFragment fragment = new HomeChildFragment();
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
        return R.layout.news_fragment_home_child;
    }

    @Override
    protected void initViews(View view) {
        mDates = new ArrayList<>();
        mRecyclerView = view.findViewById(R.id.child_rv);
    }

    @Override
    protected void initData() {
        for (int i =0; i < 20; i++){
            mDates.add("dadasdasd----->" + i);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mTableChildAdapter = new HomeChildAdapter(getContext(), mDates);
        mRecyclerView.setAdapter(mTableChildAdapter);

    }
}






















