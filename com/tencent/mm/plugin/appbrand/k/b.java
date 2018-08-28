package com.tencent.mm.plugin.appbrand.k;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static AtomicInteger gkJ = new AtomicInteger(1);
    public HashMap<String, a> fNX;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.fNX = new HashMap();
    }

    public static int alq() {
        return gkJ.incrementAndGet();
    }

    public static b alr() {
        return a.als();
    }

    public final a uI(String str) {
        if (this.fNX.containsKey(str)) {
            return (a) this.fNX.get(str);
        }
        return null;
    }
}
