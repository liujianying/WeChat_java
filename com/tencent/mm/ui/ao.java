package com.tencent.mm.ui;

import android.util.Log;

public final class ao {
    private static a tqO;
    private static a tqP;

    public interface a {
    }

    static {
        a anonymousClass1 = new a() {
        };
        tqO = anonymousClass1;
        tqP = anonymousClass1;
    }

    public static void r(String str, Object... objArr) {
        if (tqP != null) {
            String.format(str, objArr);
        }
    }

    public static void s(String str, Object... objArr) {
        if (tqP != null) {
            String.format(str, objArr);
        }
    }

    public static void t(String str, Object... objArr) {
        if (tqP != null) {
            String.format(str, objArr);
        }
    }

    public static void u(String str, Object... objArr) {
        if (tqP != null) {
            String.format(str, objArr);
        }
    }

    public static void v(String str, Object... objArr) {
        if (tqP != null) {
            String.format(str, objArr);
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        if (tqP != null) {
            String format = String.format(str, objArr);
            if (format == null) {
                format = "";
            }
            new StringBuilder().append(format).append("  ").append(Log.getStackTraceString(th));
        }
    }
}
