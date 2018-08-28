package com.tencent.mm.plugin.webview.ui.tools.bag;

class WebViewBagBgView$1 implements Runnable {
    final /* synthetic */ WebViewBagBgView qcl;

    WebViewBagBgView$1(WebViewBagBgView webViewBagBgView) {
        this.qcl = webViewBagBgView;
    }

    public final void run() {
        WebViewBagBgView.a(this.qcl);
        this.qcl.invalidate();
    }
}
