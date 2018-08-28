package com.tencent.mm.plugin.t;

import com.tencent.mm.kernel.b.c;

public final class b implements c {
    private static b lbA;

    private b() {
    }

    public static synchronized b bcR() {
        b bVar;
        synchronized (b.class) {
            if (lbA == null) {
                lbA = new b();
            }
            bVar = lbA;
        }
        return bVar;
    }
}
