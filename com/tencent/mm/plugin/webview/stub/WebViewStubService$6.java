package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;

class WebViewStubService$6 implements Runnable {
    final /* synthetic */ WebViewStubService pUR;
    final /* synthetic */ Intent val$intent;

    WebViewStubService$6(WebViewStubService webViewStubService, Intent intent) {
        this.pUR = webViewStubService;
        this.val$intent = intent;
    }

    public final void run() {
        this.pUR.startActivity(this.val$intent);
    }
}
