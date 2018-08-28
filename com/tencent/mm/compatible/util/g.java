package com.tencent.mm.compatible.util;

import android.os.SystemClock;

public final class g {

    public static class a {
        public long dgA = SystemClock.elapsedRealtime();

        public final long Ad() {
            return SystemClock.elapsedRealtime() - this.dgA;
        }
    }

    public static int getLine() {
        return new Throwable().getStackTrace()[1].getLineNumber();
    }

    public static String Ab() {
        return new Throwable().getStackTrace()[1].toString();
    }

    public static String Ac() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return stackTraceElement.getMethodName().substring(stackTraceElement.getMethodName().lastIndexOf(46) + 1) + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }
}
