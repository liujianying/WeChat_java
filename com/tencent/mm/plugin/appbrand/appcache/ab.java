package com.tencent.mm.plugin.appbrand.appcache;

public final class ab {
    private static int fgv;

    static synchronized void jF(int i) {
        synchronized (ab.class) {
            fgv = i;
        }
    }

    public static synchronized int abL() {
        int i;
        synchronized (ab.class) {
            i = fgv;
        }
        return i;
    }
}
