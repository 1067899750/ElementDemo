package com.example.z_lib_common.bankres;

/**
 *
 * Description
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/8/16 10:56
 */
public class BankResFactory {

    private static IRes iBankRes;

    public static IRes getInstance() {
        if (iBankRes != null) {
            return iBankRes;
        }
        switch (ConfigPermission.APPLICATION_PACKAGE) {
            case "com.purang.product":
                iBankRes = new ResProduct();
                break;
            case "com.purang.check":
                iBankRes = new ResCheck();
                break;
            case "com.purang.develop":
                iBankRes = new ResDevelop();
                break;
            default:
                iBankRes = new ResDevelop();
        }
        return iBankRes;
    }
}
