package com.example.z_lib_girl.data;


import com.example.z_lib_girl.data.bean.GirlsParser;

public interface GirlsDataSource {

    interface LoadGirlsCallback {

        void onGirlsLoaded(GirlsParser girlsParser);

        void onDataNotAvailable();
    }

    void getGirls(int size, int page, LoadGirlsCallback callback);

}
