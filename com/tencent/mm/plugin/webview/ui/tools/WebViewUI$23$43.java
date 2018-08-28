package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$43 implements Runnable {
    final /* synthetic */ String dEt;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$43(23 23, String str) {
        this.pZM = 23;
        this.dEt = str;
    }

    public final void run() {
        if (this.pZM.pZJ.nTs && this.dEt != null) {
            this.pZM.pZJ.setMMTitle(this.dEt);
        }
    }
}
