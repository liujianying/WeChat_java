package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;

class g$3 implements Runnable {
    final /* synthetic */ String vEI;
    final /* synthetic */ ValueCallback vEJ;
    final /* synthetic */ g vEV;

    g$3(g gVar, String str, ValueCallback valueCallback) {
        this.vEV = gVar;
        this.vEI = str;
        this.vEJ = valueCallback;
    }

    public final void run() {
        if (this.vEV.vET != null) {
            this.vEV.vET.evaluateJavascript(this.vEI, this.vEJ);
        }
    }
}
