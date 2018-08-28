package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$23$32 implements Runnable {
    final /* synthetic */ String dMs;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$32(23 23, String str) {
        this.pZM = 23;
        this.dMs = str;
    }

    public final void run() {
        if (bi.oW(this.pZM.pZJ.mhH.getUrl())) {
            x.i("MicroMsg.WebViewUI", "setPageOwner, null url");
            return;
        }
        x.i("MicroMsg.WebViewUI", "setPageOwner, userName = " + this.dMs);
        WebViewUI.h(this.pZM.pZJ).put(this.pZM.pZJ.mhH.getUrl(), this.dMs);
    }
}
