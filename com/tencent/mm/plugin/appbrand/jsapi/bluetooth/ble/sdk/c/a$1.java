package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c;

class a$1 implements Runnable {
    final /* synthetic */ a fMi;

    a$1(a aVar) {
        this.fMi = aVar;
    }

    public final void run() {
        if (!this.fMi.anR) {
            this.fMi.a(j.fMK);
            this.fMi.done();
        }
    }
}
