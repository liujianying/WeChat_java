package com.tencent.wework.api.utils;

public class Log {
    private static int vgd = 8;
    private static ILogger vzN = new WWAPILogger(new LogcatLogger((byte) 0));

    public static void d(String str, String str2) {
        if (vgd <= 3) {
            vzN.a(3, str, str2, null);
        }
    }

    public static void i(String str, String str2) {
        if (vgd <= 4) {
            vzN.a(4, str, str2, null);
        }
    }

    public static void w(String str, String str2) {
        if (vgd <= 5) {
            vzN.a(5, str, str2, null);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (vgd <= 5) {
            vzN.a(5, str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (vgd <= 6) {
            vzN.a(6, str, str2, th);
        }
    }
}
