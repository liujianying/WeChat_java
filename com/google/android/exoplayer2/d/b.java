package com.google.android.exoplayer2.d;

public final class b {
    public static boolean DEBUG = true;
    private static a apo = null;

    public static void a(a aVar) {
        apo = aVar;
    }

    public static void i(String str, String str2, Object... objArr) {
        if (apo != null) {
            apo.i(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (apo != null) {
            apo.w(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (apo != null) {
            apo.e(str, str2, objArr);
        }
    }
}
