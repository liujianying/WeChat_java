package com.tencent.mm.plugin.appbrand.k;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class k {
    private static AtomicInteger gkJ = new AtomicInteger(1);
    public HashMap<String, j> fNX;

    /* synthetic */ k(byte b) {
        this();
    }

    private k() {
        this.fNX = new HashMap();
    }

    public static k aly() {
        return a.alz();
    }

    public final j uT(String str) {
        if (this.fNX.containsKey(str)) {
            return (j) this.fNX.get(str);
        }
        return null;
    }

    public static int alq() {
        return gkJ.incrementAndGet();
    }
}
