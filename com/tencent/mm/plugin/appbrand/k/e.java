package com.tencent.mm.plugin.appbrand.k;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class e {
    private static AtomicInteger gkJ = new AtomicInteger(1);
    public HashMap<String, c> fNX;

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        this.fNX = new HashMap();
    }

    public static int alq() {
        return gkJ.incrementAndGet();
    }

    public static e alu() {
        return a.alv();
    }

    public final c uL(String str) {
        if (this.fNX.containsKey(str)) {
            return (c) this.fNX.get(str);
        }
        return null;
    }
}
