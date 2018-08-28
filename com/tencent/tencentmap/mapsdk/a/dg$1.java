package com.tencent.tencentmap.mapsdk.a;

class dg$1 implements Runnable {
    private /* synthetic */ dg a;

    dg$1(dg dgVar) {
        this.a = dgVar;
    }

    public final void run() {
        try {
            this.a.a();
        } catch (Throwable th) {
            ct.a(th);
        }
    }
}
