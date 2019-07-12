package com.example.z_lib_girl.main;


import com.example.z_lib_girl.data.GirlsDataSource;
import com.example.z_lib_girl.data.bean.GirlsParser;
import com.example.z_lib_girl.data.source.RemoteGirlsDataSource;

/**
 * <p>类说明</p>
 */
public class GirlsPresenter implements GirlsContract.Presenter {

    private GirlsContract.View mView;
    private GirlsDataSource mDataSource;

    public GirlsPresenter(GirlsContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mDataSource = new RemoteGirlsDataSource();
    }

    @Override
    public void getGirls(int size, int page, final boolean isRefresh) {
        mDataSource.getGirls(size, page, new GirlsDataSource.LoadGirlsCallback() {
            @Override
            public void onGirlsLoaded(GirlsParser girlsParser) {
                if (isRefresh) {
                    mView.refresh(girlsParser.getResults());
                } else {
                    mView.load(girlsParser.getResults());
                }
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                if (isRefresh) {
                    mView.showError();
                }
            }
        });
    }

    @Override
    public void start() {
        getGirls(20, 1, true);
    }
}
