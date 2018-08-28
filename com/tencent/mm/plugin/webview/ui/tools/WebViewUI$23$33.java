package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.g.a.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$33 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ Bundle qah;
    final /* synthetic */ j qai;

    WebViewUI$23$33(23 23, Bundle bundle, j jVar) {
        this.pZM = 23;
        this.qah = bundle;
        this.qai = jVar;
    }

    public final void run() {
        this.qah.putAll(this.qai.bGp.bGt);
    }
}
