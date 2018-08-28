package com.tencent.tencentmap.mapsdk.a;

import java.util.Locale;

public final class ct {
    public static boolean a = false;
    public static boolean b = false;

    public static void a(String str, Object... objArr) {
        if ((a ? 1 : null) != null && str != null && objArr != null && objArr.length != 0) {
            String.format(Locale.US, str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        if ((a ? 1 : null) != null && str != null && objArr != null && objArr.length != 0) {
            String.format(Locale.US, str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        if (str != null && objArr != null && objArr.length != 0) {
            String.format(Locale.US, str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (str != null && objArr != null && objArr.length != 0) {
            String.format(Locale.US, str, objArr);
        }
    }

    public static void a(Throwable th) {
        if (th != null && (th instanceof Throwable)) {
            if ((a ? 1 : 0) == 0) {
                d(th.getMessage(), new Object[0]);
            }
        }
    }

    private static void a(String str, String str2, Object... objArr) {
        if ((a ? 1 : null) != null && str2 != null && objArr != null && objArr.length != 0) {
            String.format(Locale.US, str2, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        a("beacon_step_api", str, objArr);
    }

    public static void f(String str, Object... objArr) {
        a("beacon_step_buffer", str, objArr);
    }

    public static void g(String str, Object... objArr) {
        a("beacon_step_db", str, objArr);
    }

    public static void h(String str, Object... objArr) {
        a("beacon_step_upload", str, objArr);
    }
}
