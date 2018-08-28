package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$23 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$23(23 23, Bundle bundle) {
        this.pZM = 23;
        this.bAE = bundle;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null && this.pZM.pZJ.gcP != null && this.pZM.pZJ.gcP.bVR() != null && this.pZM.pZJ.gcP.bVR().gu(42)) {
            this.pZM.pZJ.pNV.f(this.bAE, "download_removed");
        }
    }
}
