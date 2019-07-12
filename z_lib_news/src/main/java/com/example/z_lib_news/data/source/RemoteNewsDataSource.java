package com.example.z_lib_news.data.source;


import com.example.z_lib_common.base.InfoCallback;
import com.example.z_lib_common.http.DataType;
import com.example.z_lib_common.http.HttpClient;
import com.example.z_lib_common.http.OnResultListener;
import com.example.z_lib_news.Constants;
import com.example.z_lib_news.data.NewsDataSource;
import com.example.z_lib_news.data.bean.MessageDetail;
import com.example.z_lib_news.data.bean.StoryList;

/**
 * <p>类说明</p>
 */
public class RemoteNewsDataSource implements NewsDataSource {

    @Override
    public void getNewsList(String date, final InfoCallback<StoryList> callback) {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE)
                .url(date)
                .bodyType(DataType.JSON_OBJECT, StoryList.class)
                .build();
        client.get(new OnResultListener<StoryList>() {

            @Override
            public void onSuccess(StoryList result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(int code, String message) {
                callback.onError(code, message);
            }

            @Override
            public void onFailure(String message) {
                callback.onError(0, message);
            }
        });
    }


    @Override
    public void getNewsDetail(String id, final InfoCallback<MessageDetail> callback) {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE_DETAIL)
                .url(id)
                .bodyType(DataType.JSON_OBJECT, MessageDetail.class)
                .build();
        client.get(new OnResultListener<MessageDetail>() {

            @Override
            public void onSuccess(MessageDetail result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(int code, String message) {
                callback.onError(code, message);
            }

            @Override
            public void onFailure(String message) {
                callback.onError(0, message);
            }
        });
    }


}
