package com.tencent.mm.plugin.appbrand.page;

import android.webkit.ValueCallback;

class t$3 implements Runnable {
    final /* synthetic */ String fwG;
    final /* synthetic */ ValueCallback fwH;
    final /* synthetic */ t goK;

    t$3(t tVar, String str, ValueCallback valueCallback) {
        this.goK = tVar;
        this.fwG = str;
        this.fwH = valueCallback;
    }

    public final void run() {
        t.a(this.goK, this.fwG, this.fwH);
    }
}
