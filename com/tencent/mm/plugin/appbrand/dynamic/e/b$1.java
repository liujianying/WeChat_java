package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.webkit.ValueCallback;

class b$1 implements Runnable {
    final /* synthetic */ ValueCallback fwH;
    final /* synthetic */ String fwM;
    final /* synthetic */ b fwN;

    b$1(b bVar, String str, ValueCallback valueCallback) {
        this.fwN = bVar;
        this.fwM = str;
        this.fwH = valueCallback;
    }

    public final void run() {
        b.a(this.fwN, this.fwM, this.fwH);
    }
}
