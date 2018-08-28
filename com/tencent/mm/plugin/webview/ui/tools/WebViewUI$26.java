package com.tencent.mm.plugin.webview.ui.tools;

class WebViewUI$26 implements Runnable {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$26(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void run() {
        this.pZJ.mhH.getCurWebviewClient().a(this.pZJ.mhH, this.pZJ.mhH.getUrl());
    }
}
