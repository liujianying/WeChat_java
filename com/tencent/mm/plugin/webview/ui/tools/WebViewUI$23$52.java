package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$52 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ int qaq;
    final /* synthetic */ String qar;

    WebViewUI$23$52(23 23, String str, int i) {
        this.pZM = 23;
        this.qar = str;
        this.qaq = i;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            this.pZM.pZJ.pNV.cC(this.qar, this.qaq);
        }
    }
}
