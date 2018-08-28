package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.a;

class a$a$1 implements Runnable {
    final /* synthetic */ int fli;
    final /* synthetic */ a gdO;

    a$a$1(a aVar, int i) {
        this.gdO = aVar;
        this.fli = i;
    }

    public final void run() {
        this.gdO.gdN.g(false, "fail to connect wifi:actionListener" + this.fli);
    }
}
