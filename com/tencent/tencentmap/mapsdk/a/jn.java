package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public class jn {
    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String packageName = context.getPackageName();
            if (packageName == null || packageName.length() == 0) {
                return "";
            }
            if (packageName.length() > 255) {
                return packageName.substring(0, 254);
            }
            return packageName;
        } catch (Exception e) {
            return "";
        }
    }
}
