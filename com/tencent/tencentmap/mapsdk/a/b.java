package com.tencent.tencentmap.mapsdk.a;

public abstract class b {
    public static boolean a = true;
    private static b b;

    public abstract void a(int i);

    public abstract void a(int i, Runnable runnable, long j, long j2);

    public abstract void a(Runnable runnable);

    public abstract void a(Runnable runnable, long j);

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new a();
            }
            bVar = b;
        }
        return bVar;
    }
}
