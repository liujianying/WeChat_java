package com.tencent.matrix.d;

import android.util.Log;

public final class b {
    private static a buV;
    private static a buW;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        a anonymousClass1 = new a() {
            public final void v(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void i(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void d(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void w(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void e(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                String format = (objArr == null || objArr.length == 0) ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                new StringBuilder().append(format).append("  ").append(Log.getStackTraceString(th));
            }
        };
        buV = anonymousClass1;
        buW = anonymousClass1;
    }

    public static void b(a aVar) {
        buW = aVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (buW != null) {
            buW.v(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (buW != null) {
            buW.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (buW != null) {
            buW.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (buW != null) {
            buW.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (buW != null) {
            buW.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (buW != null) {
            buW.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
