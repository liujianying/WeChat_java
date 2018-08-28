package com.tencent.smtt.sdk;

import android.os.Message;
import android.webkit.WebView.WebViewTransport;

class z implements Runnable {
    final /* synthetic */ WebView$WebViewTransport a;
    final /* synthetic */ Message b;
    final /* synthetic */ SystemWebChromeClient c;

    z(SystemWebChromeClient systemWebChromeClient, WebView$WebViewTransport webView$WebViewTransport, Message message) {
        this.c = systemWebChromeClient;
        this.a = webView$WebViewTransport;
        this.b = message;
    }

    public void run() {
        WebView webView = this.a.getWebView();
        if (webView != null) {
            ((WebViewTransport) this.b.obj).setWebView(webView.b());
        }
        this.b.sendToTarget();
    }
}
