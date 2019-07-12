package com.example.z_lib_news.detail;


import com.example.z_lib_common.base.InfoCallback;
import com.example.z_lib_news.data.NewsDataSource;
import com.example.z_lib_news.data.bean.MessageDetail;
import com.example.z_lib_news.data.source.RemoteNewsDataSource;

/**
 * <p>类说明</p>
 */
public class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private NewsDetailContract.View mView;
    private NewsDataSource mDataSource;

    public NewsDetailPresenter(NewsDetailContract.View view) {
        mView = view;
        mDataSource = new RemoteNewsDataSource();
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getNewsDetail(String newsId) {
        mDataSource.getNewsDetail(newsId, new InfoCallback<MessageDetail>() {
            @Override
            public void onSuccess(MessageDetail detail) {
                if (mView.isActive()) {
                    mView.showNewsDetail(detail);
                }
            }

            @Override
            public void onError(int code, String message) {

            }
        });
    }

}
