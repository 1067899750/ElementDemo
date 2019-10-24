package com.example.z_lib_user.activity.model;


import com.example.z_lib_common.base.mvp.Model;

import java.util.List;

import io.reactivex.Observable;
/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/8 14:27
 */
public interface MainModel extends Model {
    /**
     * 从网络获取数据
     *
     * @return
     */
    Observable<List<User>> getDataFromNet();

    /**
     *  str -> data
     * @return
     */
    String getDataFromString();

    /**
     * 停止请求
     */
    void stopRequest();
}
