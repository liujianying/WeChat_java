package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.bd;

class WebViewUI$2 extends bd<String> {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$2(WebViewUI webViewUI, String str) {
        this.pZJ = webViewUI;
        super(1000, str, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return this.pZJ.mhH == null ? "" : this.pZJ.mhH.getUrl();
    }
}
