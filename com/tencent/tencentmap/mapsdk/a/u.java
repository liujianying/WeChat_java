package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class u {
    public static boolean a(Context context) {
        NetworkInfo b = b(context);
        if (b == null || b.getType() != 1) {
            return false;
        }
        return true;
    }

    public static NetworkInfo b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? null : activeNetworkInfo;
    }
}
