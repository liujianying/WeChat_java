package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.stub.WebViewStubService.1;

class WebViewStubService$1$2 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ Bundle fFU;
    final /* synthetic */ 1 pUU;

    WebViewStubService$1$2(1 1, Bundle bundle, Bundle bundle2) {
        this.pUU = 1;
        this.bAE = bundle;
        this.fFU = bundle2;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtras(this.bAE);
        intent.putExtra("isFromWebView", true);
        intent.putExtra("_stat_obj", this.fFU);
        a.ezn.r(intent, this.pUU.pUR);
    }
}
