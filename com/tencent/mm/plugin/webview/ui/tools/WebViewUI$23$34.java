package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$34 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ int fdk;
    final /* synthetic */ 23 pZM;
    final /* synthetic */ long qaj;

    WebViewUI$23$34(23 23, String str, long j, int i) {
        this.pZM = 23;
        this.bAj = str;
        this.qaj = j;
        this.fdk = i;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null && this.pZM.pZJ.gcP != null && this.pZM.pZJ.gcP.bVR() != null && this.pZM.pZJ.gcP.bVR().gu(42)) {
            this.pZM.pZJ.pNV.g(this.bAj, this.qaj, this.fdk);
        }
    }
}
