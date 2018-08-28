package com.tencent.tencentmap.mapsdk.a;

public final class dx {
    private static dx c;
    public dy a;
    public dz b = new dz();

    private dx() {
        this.b.a();
        this.a = new dy();
        this.a.a();
    }

    public static synchronized dx a() {
        dx dxVar;
        synchronized (dx.class) {
            if (c == null) {
                c = new dx();
            }
            dxVar = c;
        }
        return dxVar;
    }
}
