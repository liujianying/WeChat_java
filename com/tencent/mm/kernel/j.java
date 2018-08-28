package com.tencent.mm.kernel;

import com.tencent.mm.sdk.platformtools.x;

public final class j {
    private static long drm;
    private static volatile a drn = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void aB(long j) {
        drm = j;
    }

    public static void i(String str, long j) {
        long nanoTime = System.nanoTime() - j;
        x.i("Blink-LOG", "since the %s : %s", str, Long.valueOf(nanoTime));
    }

    public static void ey(String str) {
        long currentTimeMillis = System.currentTimeMillis() - drm;
        x.i("Blink-LOG", "since startup %s : %s", str, Long.valueOf(currentTimeMillis));
        String.format("since startup %s : %s", new Object[]{str, Long.valueOf(currentTimeMillis)});
    }

    public static void a(a aVar) {
        drn = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (drn != null) {
            drn.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (drn != null) {
            drn.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (drn != null) {
            drn.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (drn != null) {
            drn.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (drn != null) {
            drn.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
