package com.example.z_lib_girl.data.source;


import com.example.z_lib_common.http.DataType;
import com.example.z_lib_common.http.HttpClient;
import com.example.z_lib_common.http.OnResultListener;
import com.example.z_lib_girl.Constants;
import com.example.z_lib_girl.data.GirlsDataSource;
import com.example.z_lib_girl.data.bean.GirlsParser;

public class RemoteGirlsDataSource implements GirlsDataSource {

    @Override
    public void getGirls(int size, int page, final LoadGirlsCallback callback) {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.GAN_HUO_API)
                .url("福利/" + size + "/" + page)
                .bodyType(DataType.JSON_OBJECT, GirlsParser.class)
                .build();
        client.get(new OnResultListener<GirlsParser>() {

            @Override
            public void onSuccess(GirlsParser result) {
                callback.onGirlsLoaded(result);
            }

            @Override
            public void onError(int code, String message) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onFailure(String message) {
                callback.onDataNotAvailable();
            }
        });
    }

}
