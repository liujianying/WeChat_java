package com.tencent.mm.plugin.appbrand.jsapi.live;

class a$2 implements Runnable {
    final /* synthetic */ String fRy;
    final /* synthetic */ String fRz;
    final /* synthetic */ String val$url;

    a$2(String str, String str2, String str3) {
        this.val$url = str;
        this.fRy = str2;
        this.fRz = str3;
    }

    public final void run() {
        a.C(this.val$url, this.fRy, this.fRz);
    }
}
