package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubProxyUI$7 implements a {
    final /* synthetic */ WebViewStubProxyUI pUE;

    WebViewStubProxyUI$7(WebViewStubProxyUI webViewStubProxyUI) {
        this.pUE = webViewStubProxyUI;
    }

    public final boolean vD() {
        if (this.pUE.getWindow() != null && this.pUE.getWindow().getDecorView() != null && this.pUE.getWindow().getDecorView().getWindowToken() != null) {
            WebViewStubProxyUI.e(this.pUE);
            WebViewStubProxyUI.f(this.pUE);
            return false;
        } else if (WebViewStubProxyUI.c(this.pUE) < 10) {
            WebViewStubProxyUI.d(this.pUE);
            return true;
        } else {
            x.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
            this.pUE.finish();
            return false;
        }
    }
}
