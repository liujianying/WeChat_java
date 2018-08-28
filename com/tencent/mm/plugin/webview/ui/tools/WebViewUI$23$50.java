package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.sdk.platformtools.bi;

class WebViewUI$23$50 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String qao;
    final /* synthetic */ String val$url;

    WebViewUI$23$50(23 23, String str, String str2) {
        this.pZM = 23;
        this.val$url = str;
        this.qao = str2;
    }

    public final void run() {
        if (!bi.oW(this.val$url)) {
            if (!bi.oW(this.qao)) {
                this.pZM.pZJ.getIntent().putExtra("view_port_code", this.qao);
            }
            this.pZM.pZJ.mhH.loadUrl(this.val$url);
        }
    }
}
