package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.webkit.ValueCallback;

class a$1 implements Runnable {
    final /* synthetic */ String fwG;
    final /* synthetic */ ValueCallback fwH;
    final /* synthetic */ a fwI;

    a$1(a aVar, String str, ValueCallback valueCallback) {
        this.fwI = aVar;
        this.fwG = str;
        this.fwH = valueCallback;
    }

    public final void run() {
        this.fwI.fwC.evaluateJavascript(this.fwG, this.fwH);
    }
}
