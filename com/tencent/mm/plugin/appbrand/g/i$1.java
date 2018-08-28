package com.tencent.mm.plugin.appbrand.g;

import android.webkit.ValueCallback;

class i$1 implements Runnable {
    final /* synthetic */ String fwG;
    final /* synthetic */ ValueCallback fwH;
    final /* synthetic */ i gdS;

    i$1(i iVar, String str, ValueCallback valueCallback) {
        this.gdS = iVar;
        this.fwG = str;
        this.fwH = valueCallback;
    }

    public final void run() {
        i.a(this.gdS).evaluateJavascript(this.fwG, this.fwH);
    }
}
