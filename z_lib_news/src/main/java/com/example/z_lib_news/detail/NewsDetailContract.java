package com.example.z_lib_news.detail;


import com.example.z_lib_common.base.BasePresenter;
import com.example.z_lib_common.base.BaseView;
import com.example.z_lib_news.data.bean.MessageDetail;

/**
 * <p>类说明</p>
 */
public interface NewsDetailContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showNewsDetail(MessageDetail detail);

    }

    interface Presenter extends BasePresenter {

        /**
         * 获取最新列表
         *
         * @param newsId 新闻id
         */
        void getNewsDetail(String newsId);

    }

}
