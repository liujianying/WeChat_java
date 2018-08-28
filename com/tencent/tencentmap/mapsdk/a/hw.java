package com.tencent.tencentmap.mapsdk.a;

import android.os.Build;

public class hw {
    private static String[] a = new String[0];

    public static boolean a() {
        String str = Build.MODEL;
        for (String equalsIgnoreCase : a) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }
}
