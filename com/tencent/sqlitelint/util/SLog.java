package com.tencent.sqlitelint.util;

import com.tencent.matrix.d.b;

public class SLog {
    private static final String TAG = "SQLiteLint.SLog";
    private static volatile SLog mInstance = null;

    public static native void nativeSetLogger(int i);

    public static SLog getInstance() {
        if (mInstance == null) {
            synchronized (SLog.class) {
                if (mInstance == null) {
                    mInstance = new SLog();
                }
            }
        }
        return mInstance;
    }

    public void printLog(int i, String str, String str2) {
        switch (i) {
            case 2:
                b.v(str, str2, new Object[0]);
                return;
            case 3:
                b.d(str, str2, new Object[0]);
                return;
            case 4:
                b.i(str, str2, new Object[0]);
                return;
            case 5:
                b.w(str, str2, new Object[0]);
                return;
            case 6:
            case 7:
                b.e(str, str2, new Object[0]);
                return;
            default:
                try {
                    b.i(str, str2, new Object[0]);
                    return;
                } catch (Throwable th) {
                    new StringBuilder("printLog ex ").append(th.getMessage());
                }
        }
        new StringBuilder("printLog ex ").append(th.getMessage());
    }

    public static void e(String str, String str2, Object... objArr) {
        getInstance().printLog(6, str, String.format(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        getInstance().printLog(5, str, String.format(str2, objArr));
    }

    public static void i(String str, String str2, Object... objArr) {
        getInstance().printLog(4, str, String.format(str2, objArr));
    }

    public static void d(String str, String str2, Object... objArr) {
        getInstance().printLog(3, str, String.format(str2, objArr));
    }

    public static void v(String str, String str2, Object... objArr) {
        getInstance().printLog(2, str, String.format(str2, objArr));
    }
}
