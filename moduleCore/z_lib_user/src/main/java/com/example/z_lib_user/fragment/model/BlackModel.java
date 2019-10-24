package com.example.z_lib_user.fragment.model;


import com.example.z_lib_common.base.mvp.Model;

/**
 * @author puyantao
 * @description
 * @date 2019/10/8 14:51
 */
public interface BlackModel extends Model {
    /**
     *  获取数据
     * @return
     */
    String getDataFromHWW();

    /**
     * 停止请求数据
     */
    void stopRequest();
}
