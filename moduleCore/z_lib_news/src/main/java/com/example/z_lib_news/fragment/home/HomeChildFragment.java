package com.example.z_lib_news.fragment.home;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.z_lib_common.base.mvc.fragment.BaseMvcFragment;
import com.example.z_lib_news.R;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/5 17:12
 */
public class HomeChildFragment extends BaseMvcFragment {
    private RecyclerView mRecyclerView;
    private HomeChildAdapter mHomeChildAdapter;
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
        mHomeChildAdapter = new HomeChildAdapter(getContext(), mDates);
        mRecyclerView.setAdapter(mHomeChildAdapter);

    }

    @Override
    protected void onSuccess(String tag, JsonObject jsonObject) {

    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onError(int code, String message) {

    }
}






















