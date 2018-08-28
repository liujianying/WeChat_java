package com.tencent.tencentmap.mapsdk.a;

class d$1 implements Runnable {
    d$1() {
    }

    public final void run() {
        ct.b(" db events to up on netConnectChange", new Object[0]);
        try {
            dl.a(true);
        } catch (Throwable th) {
            ct.a(th);
        }
    }
}
