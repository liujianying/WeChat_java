package com.tinkerboots.sdk.a;

import com.tinkerboots.sdk.a.a.b;

public final class a {
    private static volatile a vGc;
    public long fqj = 10800000;
    public boolean isDebug;
    public b vGb;
    public final com.tinkerboots.sdk.a.b.a vGd = com.tinkerboots.sdk.a.b.a.cJD();

    private a(b bVar) {
        this.vGb = bVar;
    }

    public static a a(b bVar) {
        if (vGc != null) {
            throw new RuntimeException("tinker server client is already init");
        }
        if (vGc == null) {
            synchronized (com.tinkerboots.sdk.a.b.a.class) {
                if (vGc == null) {
                    vGc = new a(bVar);
                }
            }
        }
        return vGc;
    }
}
