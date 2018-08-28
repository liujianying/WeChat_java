package com.tencent.tencentmap.mapsdk.a;

class db$3 implements Runnable {
    db$3() {
    }

    public final void run() {
        ct.f(" db events to up", new Object[0]);
        try {
            dl.a(false);
        } catch (Throwable th) {
            ct.a(th);
        }
    }
}
