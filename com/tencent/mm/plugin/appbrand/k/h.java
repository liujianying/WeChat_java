package com.tencent.mm.plugin.appbrand.k;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class h {
    private static AtomicInteger gkJ = new AtomicInteger(1);
    public HashMap<String, f> fNX;

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        this.fNX = new HashMap();
    }

    public static int alq() {
        return gkJ.incrementAndGet();
    }

    public static h alw() {
        return a.alx();
    }

    public final f uN(String str) {
        if (this.fNX.containsKey(str)) {
            return (f) this.fNX.get(str);
        }
        return null;
    }
}
