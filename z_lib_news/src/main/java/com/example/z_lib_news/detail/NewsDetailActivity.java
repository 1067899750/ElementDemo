package com.example.z_lib_news.detail;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.base.BaseActivity;


/**
 * <p>类说明</p>
 */
@Route(path = "/news/detail")
public class NewsDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewsDetailView detailView = new NewsDetailView(this);
        setContentView(detailView);
        String id = getIntent().getStringExtra("id");
        new NewsDetailPresenter(detailView).getNewsDetail(id);
    }

}















