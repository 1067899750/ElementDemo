package com.example.z_lib_girl.main;


import com.example.z_lib_common.base.BasePresenter;
import com.example.z_lib_common.base.BaseView;
import com.example.z_lib_girl.data.bean.Girls;

import java.util.List;

/**
 * <p>类说明</p>
 */
public interface GirlsContract {

    interface View extends BaseView<Presenter> {

        /**
         * View 的存活状态
         *
         * @return true or false
         */
        boolean isActive();

        void refresh(List<Girls> data);

        void load(List<Girls> data);

        void showError();

        void showNormal();

    }

    interface Presenter extends BasePresenter {

        void getGirls(int page, int size, boolean isRefresh);

    }


}
