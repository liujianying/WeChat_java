package com.tencent.mm.plugin.appbrand.dynamic.i;

class b$a {
    volatile int count;
    volatile long fxB;
    volatile long fxC;
    volatile long fxD;

    private b$a() {
    }

    /* synthetic */ b$a(byte b) {
        this();
    }

    final synchronized void reset() {
        this.fxB = 0;
        this.fxC = 0;
        this.count = 0;
    }
}
