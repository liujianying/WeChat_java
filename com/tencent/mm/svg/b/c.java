package com.tencent.mm.svg.b;

public final class c {
    private static a tfs = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);
    }

    public static void b(a aVar) {
        tfs = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (tfs != null) {
            tfs.e(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (tfs != null) {
            tfs.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (tfs != null) {
            tfs.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (tfs != null) {
            tfs.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
