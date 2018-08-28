package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.model.ak$g;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a;

class WebViewUI$10 implements a {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$10(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void bVF() {
        if (this.pZJ.mhH.getIsX5Kernel()) {
            ak$g bUy = this.pZJ.pQY.bUy();
            bUy.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(10)};
            bUy.c(this.pZJ.gcO);
        }
    }
}
