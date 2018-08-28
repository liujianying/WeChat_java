package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;

class WebViewUI$i$1 implements Runnable {
    final /* synthetic */ i qaJ;
    final /* synthetic */ String val$url;

    WebViewUI$i$1(i iVar, String str) {
        this.qaJ = iVar;
        this.val$url = str;
    }

    public final void run() {
        this.qaJ.pZJ.Do(this.val$url);
    }
}
