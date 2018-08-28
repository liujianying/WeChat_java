package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.PackageInfo;

public final class em {
    private static Context a = null;
    private static String b = "";
    private static String c = "null";
    private static int d = 0;
    private static String e = "";
    private static String f = "";
    private static String g = "1.5.6.1223-M-HC-B";

    public static Context a() {
        return a;
    }

    public static void a(Context context, String str, String str2, String str3) {
        a = context.getApplicationContext();
        b = str;
        e = str3;
        f = str2;
        g = "1.5.6.1223-M-HC-B";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            c = packageInfo.versionName;
            d = packageInfo.versionCode;
        } catch (Throwable th) {
        }
    }

    public static String b() {
        return b;
    }

    public static String c() {
        return c;
    }

    public static int d() {
        return d;
    }

    public static String e() {
        return e;
    }

    public static String f() {
        return g;
    }

    public static String g() {
        return f;
    }
}
