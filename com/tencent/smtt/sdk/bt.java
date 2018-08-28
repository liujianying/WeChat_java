package com.tencent.smtt.sdk;

class bt extends Thread {
    final /* synthetic */ WebView a;

    bt(WebView webView, String str) {
        this.a = webView;
        super(str);
    }

    public void run() {
        this.a.a();
    }
}
