package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;

class b$4 implements Runnable {
    final /* synthetic */ b vEH;
    final /* synthetic */ String vEI;
    final /* synthetic */ ValueCallback vEJ;

    b$4(b bVar, String str, ValueCallback valueCallback) {
        this.vEH = bVar;
        this.vEI = str;
        this.vEJ = valueCallback;
    }

    public final void run() {
        if (this.vEH.vED != null) {
            XWAppBrandEngine xWAppBrandEngine = this.vEH.vED;
            String evaluateJavascript = xWAppBrandEngine.evaluateJavascript(xWAppBrandEngine.mInstance, this.vEI);
            if (this.vEJ != null) {
                this.vEJ.onReceiveValue(evaluateJavascript);
            }
        }
    }
}
