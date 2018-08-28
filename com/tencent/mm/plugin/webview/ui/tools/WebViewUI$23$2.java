package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$2 implements Runnable {
    final /* synthetic */ int eNW;
    final /* synthetic */ String fQh;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$2(23 23, String str, int i) {
        this.pZM = 23;
        this.fQh = str;
        this.eNW = i;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            this.pZM.pZJ.pNV.cE(this.fQh, this.eNW);
        }
    }
}
