package com.example.z_lib_news.fragment.table;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_news.R;

import java.util.ArrayList;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/5 17:12
 */
public class TableChildFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private TableChildAdapter mTableChildAdapter;
    private ArrayList<String> mDates;


    public TableChildFragment() {
        // Required empty public constructor
    }


    public static TableChildFragment newInstance() {
        TableChildFragment fragment = new TableChildFragment();
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
        return R.layout.news_fragment_table_child;
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
        mTableChildAdapter = new TableChildAdapter(getContext(), mDates);
        mRecyclerView.setAdapter(mTableChildAdapter);

    }
}






















