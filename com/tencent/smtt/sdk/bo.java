package com.tencent.smtt.sdk;

class bo extends Thread {
    final /* synthetic */ WebView a;

    bo(WebView webView, String str) {
        this.a = webView;
        super(str);
    }

    public void run() {
        this.a.tbsWebviewDestroy(false);
    }
}
