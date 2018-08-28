package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.sdk.platformtools.al.a;

class WebViewStubProxyUI$8 implements a {
    final /* synthetic */ WebViewStubProxyUI pUE;

    WebViewStubProxyUI$8(WebViewStubProxyUI webViewStubProxyUI) {
        this.pUE = webViewStubProxyUI;
    }

    public final boolean vD() {
        if (!this.pUE.isFinishing()) {
            this.pUE.finish();
        }
        return false;
    }
}
