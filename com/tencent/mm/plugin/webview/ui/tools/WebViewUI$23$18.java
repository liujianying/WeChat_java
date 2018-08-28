package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$18 implements Runnable {
    final /* synthetic */ double dSA;
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String pZW;
    final /* synthetic */ int pZX;
    final /* synthetic */ int pZY;
    final /* synthetic */ double pZZ;
    final /* synthetic */ float qaa;

    WebViewUI$23$18(23 23, String str, int i, int i2, double d, double d2, float f) {
        this.pZM = 23;
        this.pZW = str;
        this.pZX = i;
        this.pZY = i2;
        this.dSA = d;
        this.pZZ = d2;
        this.qaa = f;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            this.pZM.pZJ.pNV.a(this.pZW, this.pZX, this.pZY, this.dSA, this.pZZ, this.qaa);
        }
    }
}
