package com.tencent.mm.compatible.d;

public final class a {
    public static final int dbt = 1;
    private static volatile a dbu = new 1();
    private static final /* synthetic */ int[] dbv = new int[]{dbt};

    public static synchronized void a(a aVar) {
        synchronized (a.class) {
            dbu = aVar;
        }
    }

    public static void aK(long j) {
        dbu.aL(j);
    }
}
