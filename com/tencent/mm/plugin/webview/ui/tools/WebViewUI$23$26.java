package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;

class WebViewUI$23$26 implements Runnable {
    final /* synthetic */ String jJS;
    final /* synthetic */ String pUG;
    final /* synthetic */ Bundle pUH;
    final /* synthetic */ boolean pUI;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$26(23 23, String str, String str2, Bundle bundle, boolean z) {
        this.pZM = 23;
        this.pUG = str;
        this.jJS = str2;
        this.pUH = bundle;
        this.pUI = z;
    }

    public final void run() {
        this.pZM.pZJ.pNV.a(this.pUG, this.jJS, i.ac(this.pUH), this.pUI);
    }
}
