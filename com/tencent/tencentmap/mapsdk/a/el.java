package com.tencent.tencentmap.mapsdk.a;

public abstract class el {
    private static el a;

    public static synchronized el a() {
        el elVar;
        synchronized (el.class) {
            if (a == null) {
                a = new a();
            }
            elVar = a;
        }
        return elVar;
    }

    public abstract void a(Runnable runnable);
}
