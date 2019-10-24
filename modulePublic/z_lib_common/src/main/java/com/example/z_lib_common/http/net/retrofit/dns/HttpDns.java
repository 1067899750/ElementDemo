package com.example.z_lib_common.http.net.retrofit.dns;

/**
 *
 * @description IP基类
 * @author puyantao
 * @date 2019/10/14 10:22
 */
public class HttpDns {
    private static HttpDns mInstance = null;
    /**
     *  URL
     */
    public static String baseUrl;

    public static HttpDns getInstance() {
        if (mInstance == null) {
            synchronized (HttpDns.class) {
                if (mInstance == null) {
                    mInstance = new HttpDns();
                }
            }
        }
        return mInstance;
    }

    public static void init(String url) {
        baseUrl = url;
    }


    public static String getIp() {
        return baseUrl;
    }
}













