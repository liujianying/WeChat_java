package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$3 implements Runnable {
    final /* synthetic */ int eNW;
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String pZN;

    WebViewUI$23$3(23 23, String str, int i) {
        this.pZM = 23;
        this.pZN = str;
        this.eNW = i;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            this.pZM.pZJ.pNV.cF(this.pZN, this.eNW);
        }
    }
}
