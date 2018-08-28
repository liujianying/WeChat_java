package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.xweb.WebView;

class s$2 implements Runnable {
    final /* synthetic */ WebView qUt;
    final /* synthetic */ boolean qUu;
    final /* synthetic */ String qUv;
    final /* synthetic */ String qao;

    s$2(boolean z, WebView webView, String str, String str2) {
        this.qUu = z;
        this.qUt = webView;
        this.qUv = str;
        this.qao = str2;
    }

    public final void run() {
        if (this.qUu) {
            this.qUt.evaluateJavascript("javascript:document.getElementById('_edw_iframe_').src = '" + this.qUv + "' + " + this.qao, null);
        } else {
            this.qUt.evaluateJavascript("javascript:console.log('" + this.qUv + "' + " + this.qao + ")", null);
        }
    }
}
