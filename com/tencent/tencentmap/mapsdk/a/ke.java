package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ke extends mx implements kr {
    private static AtomicInteger a = new AtomicInteger(1);
    private final String b = String.valueOf(a.incrementAndGet());

    public abstract void d();

    public void u() {
    }

    public boolean q() {
        return false;
    }

    public final String v() {
        return this.b;
    }
}
