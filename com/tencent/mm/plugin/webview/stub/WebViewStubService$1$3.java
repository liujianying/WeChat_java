package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.webview.stub.WebViewStubService.1;

class WebViewStubService$1$3 implements Runnable {
    final /* synthetic */ 1 pUU;
    final /* synthetic */ int pUV;
    final /* synthetic */ int pUW;

    WebViewStubService$1$3(1 1, int i, int i2) {
        this.pUU = 1;
        this.pUV = i;
        this.pUW = i2;
    }

    public final void run() {
        au.HU();
        c.DT().set(this.pUV, Integer.valueOf(this.pUW));
    }
}
