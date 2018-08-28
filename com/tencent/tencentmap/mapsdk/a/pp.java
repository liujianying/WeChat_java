package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.map.lib.util.StringUtil;

public class pp {
    public static NetworkInfo a(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(a(context));
    }

    public static String c(Context context) {
        String str = "";
        switch (b(context)) {
            case 1:
                return "cmwap";
            case 2:
                return "uniwap";
            case 3:
                return "3gwap";
            case 4:
                return "ctwap";
            case 5:
                return "wifi";
            default:
                return str;
        }
    }

    private static int a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return 0;
        }
        int type = networkInfo.getType();
        if (type == 1) {
            return 5;
        }
        if (type != 0) {
            return 6;
        }
        String extraInfo = networkInfo.getExtraInfo();
        if (StringUtil.isEmpty(extraInfo)) {
            return 6;
        }
        if (extraInfo.equalsIgnoreCase("cmwap")) {
            return 1;
        }
        if (extraInfo.equalsIgnoreCase("3gwap")) {
            return 3;
        }
        if (extraInfo.equalsIgnoreCase("uniwap")) {
            return 2;
        }
        return extraInfo.equalsIgnoreCase("ctwap") ? 4 : 3;
    }
}
