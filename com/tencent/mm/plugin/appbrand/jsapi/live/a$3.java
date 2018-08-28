package com.tencent.mm.plugin.appbrand.jsapi.live;

class a$3 implements Runnable {
    final /* synthetic */ String fRz;
    final /* synthetic */ String val$url;

    a$3(String str, String str2) {
        this.val$url = str;
        this.fRz = str2;
    }

    public final void run() {
        a.bs(this.val$url, this.fRz);
    }
}
