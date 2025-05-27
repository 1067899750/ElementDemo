package com.example.z_lib_news.fragment.me;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.z_lib_common.base.mvc.fragment.BaseMvcFragment;
import com.example.z_lib_news.R;
import com.example.z_lib_news.fragment.home.HomeChildAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/6 16:19
 */
public class MeFragment extends BaseMvcFragment implements AppBarLayout.OnOffsetChangedListener {
    private AppBarLayout mAppBarLayout;
    private View tlExpand;
    private View tlCollapse;
    private int mMaskColor;
    private RecyclerView mRecyclerView;
    private ArrayList<String> mDates;
    private HomeChildAdapter mHomeChildAdapter;

    public MeFragment() {
    }

    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
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
    protected void beforeInit() {
        super.beforeInit();
        mDates = new ArrayList<>();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.news_fragment_me;
    }

    @Override
    protected void initViews(View root) {
        mMaskColor = getResources().getColor(R.color.c1b9cde);
        mRecyclerView = root.findViewById(R.id.rv_content);

        mAppBarLayout = root.findViewById(R.id.abl_bar);
        tlExpand = root.findViewById(R.id.tl_expand);
        tlCollapse = root.findViewById(R.id.tl_collapse);
        mAppBarLayout.addOnOffsetChangedListener(this);

    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
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

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        int offset = Math.abs(i);
        int total = appBarLayout.getTotalScrollRange();
        int alphaIn = offset;
        int alphaOut = (200-offset)<0?0:200-offset;
        int maskColorIn = Color.argb(alphaIn, Color.red(mMaskColor),
                Color.green(mMaskColor), Color.blue(mMaskColor));
        int maskColorInDouble = Color.argb(alphaIn*2, Color.red(mMaskColor),
                Color.green(mMaskColor), Color.blue(mMaskColor));
        int maskColorOut = Color.argb(alphaOut*2, Color.red(mMaskColor),
                Color.green(mMaskColor), Color.blue(mMaskColor));
        if (offset <= total / 2) {
            tlExpand.setVisibility(View.VISIBLE);
            tlCollapse.setVisibility(View.GONE);
        } else {
            tlExpand.setVisibility(View.GONE);
            tlCollapse.setVisibility(View.VISIBLE);
        }
    }
}














