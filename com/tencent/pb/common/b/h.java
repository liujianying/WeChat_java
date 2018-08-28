package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class h {
    public static boolean vcw = true;
    private static long vcx = -1;
    public static int vcy = a.vcA;
    private static int vcz = a.vcA;

    private static NetworkInfo cEr() {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) d.oSX.getSystemService("connectivity");
        } catch (Exception e) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            c.x("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
            return null;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            c.x("getActiveNetworkInfo exception:", new Object[]{th});
            activeNetworkInfo = null;
        }
        return activeNetworkInfo;
    }

    public static boolean isNetworkConnected() {
        try {
            NetworkInfo cEr = cEr();
            if (cEr == null) {
                return false;
            }
            return cEr.isConnected();
        } catch (Exception e) {
            return true;
        }
    }
}
