package com.example.z_lib_news.main;


import com.example.z_lib_common.base.BasePresenter;
import com.example.z_lib_common.base.BaseView;
import com.example.z_lib_news.data.bean.StoryList;

/**
 * <p>类说明</p>
 */
public interface NewsListContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showNewsList(StoryList info);

    }

    interface Presenter extends BasePresenter {

        /**
         * 获取最新列表
         *
         * @param date
         */
        void getNewMessages(int page, int size, String date);

    }

}
