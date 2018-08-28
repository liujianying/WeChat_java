package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;

class WebViewUI$23$42 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ Bundle qah;

    WebViewUI$23$42(23 23, Bundle bundle) {
        this.pZM = 23;
        this.qah = bundle;
    }

    public final void run() {
        this.qah.putInt("height", this.pZM.pZJ.bWd());
    }
}
