package com.tencent.mm.plugin.webview.ui.tools;

class WebViewUI$46 implements Runnable {
    final /* synthetic */ int jJP;
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$46(WebViewUI webViewUI, int i) {
        this.pZJ = webViewUI;
        this.jJP = i;
    }

    public final void run() {
        if (this.pZJ.pNV != null) {
            this.pZJ.pNV.Bc(this.jJP);
        }
    }
}
