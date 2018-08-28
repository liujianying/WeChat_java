package com.tencent.mm.plugin.webview.ui.tools.widget.input;

class WebViewSmileyPanel$1 implements Runnable {
    final /* synthetic */ WebViewSmileyPanel qlQ;

    WebViewSmileyPanel$1(WebViewSmileyPanel webViewSmileyPanel) {
        this.qlQ = webViewSmileyPanel;
    }

    public final void run() {
        this.qlQ.O(WebViewSmileyPanel.a(this.qlQ).getCurrentItem());
    }
}
