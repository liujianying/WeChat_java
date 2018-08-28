package com.tinkerboots.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class a {
    private static ConnectivityManager vGk = null;

    public static boolean isConnected(Context context) {
        if (vGk == null) {
            vGk = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (vGk == null) {
            return false;
        }
        boolean z;
        NetworkInfo activeNetworkInfo = vGk.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            try {
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                    return z;
                }
            } catch (Exception e) {
                return false;
            }
        }
        z = false;
        return z;
    }

    public static boolean isWifi(Context context) {
        if (vGk == null) {
            vGk = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (vGk == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = vGk.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
