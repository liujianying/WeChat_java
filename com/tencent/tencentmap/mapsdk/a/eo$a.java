package com.tencent.tencentmap.mapsdk.a;

class eo$a implements Runnable {
    private final fn a;

    eo$a(eo eoVar, fn fnVar) {
        this.a = fnVar;
    }

    public final void run() {
        try {
            Thread.sleep(5000);
            try {
                fo.a("B_ACSDK_SDK_Result", true, 0, 0, ee.a(this.a), true);
            } catch (Throwable th) {
            }
        } catch (InterruptedException e) {
        }
    }
}
