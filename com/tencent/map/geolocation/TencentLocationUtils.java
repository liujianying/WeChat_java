package com.tencent.map.geolocation;

import android.content.Context;
import c.t.m.g.eg;
import c.t.m.g.ei;

public class TencentLocationUtils {
    private TencentLocationUtils() {
        throw new UnsupportedOperationException();
    }

    public static double distanceBetween(TencentLocation tencentLocation, TencentLocation tencentLocation2) {
        if (tencentLocation != null && tencentLocation2 != null) {
            return ei.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), tencentLocation2.getLatitude(), tencentLocation2.getLongitude());
        }
        throw new NullPointerException();
    }

    public static double distanceBetween(double d, double d2, double d3, double d4) {
        return ei.a(d, d2, d3, d4);
    }

    public static boolean contains(TencentLocation tencentLocation, double d, TencentLocation tencentLocation2) {
        if (tencentLocation != null && tencentLocation2 != null) {
            return distanceBetween(tencentLocation, tencentLocation2) <= d;
        } else {
            throw new NullPointerException();
        }
    }

    public static boolean wgs84ToGcj02(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null || dArr.length != 2 || dArr2.length != 2) {
            return false;
        }
        return ei.a(dArr, dArr2);
    }

    public static boolean isFromGps(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return "gps".equals(tencentLocation.getProvider());
    }

    public static boolean isFromNetwork(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return "network".equals(tencentLocation.getProvider());
    }

    public static boolean isSupportGps(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        eg.a();
        return (eg.a(context) & 16) == 0;
    }
}
