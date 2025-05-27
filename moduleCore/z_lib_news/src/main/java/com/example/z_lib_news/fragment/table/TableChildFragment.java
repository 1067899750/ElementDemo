package com.example.z_lib_news.fragment.table;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.z_lib_common.base.mvc.fragment.BaseMvcFragment;
import com.example.z_lib_news.R;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * @author puyantao
 * @description
 * @date 2019/11/6 15:11
 */
public class TableChildFragment extends BaseMvcFragment {
    private RecyclerView mRecyclerView;
    private TableChildAdapter mTableChildAdapter;
    private ArrayList<String> mDates;
    private int mCount;
    private String mName;

    public TableChildFragment() {
    }


    public static TableChildFragment newInstance(int count, String name) {
        TableChildFragment fragment = new TableChildFragment();
        Bundle args = new Bundle();
        args.putInt("count", count);
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCount = getArguments().getInt("count");
            mName = getArguments().getString("name");
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.news_fragment_table_child;
    }

    @Override
    protected void initViews(View view) {
        mDates = new ArrayList<>();
        mRecyclerView = view.findViewById(R.id.table_rv);
    }

    @Override
    protected void initData() {
        for (int i =0; i < mCount; i++){
            mDates.add(mName + "----->" + i);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mTableChildAdapter = new TableChildAdapter(getContext(), mDates);
        mRecyclerView.setAdapter(mTableChildAdapter);
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
