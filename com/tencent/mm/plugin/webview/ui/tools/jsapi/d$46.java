package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class d$46 implements Runnable {
    final /* synthetic */ String fzV;
    final /* synthetic */ d qhD;
    final /* synthetic */ String qhG;

    d$46(d dVar, String str, String str2) {
        this.qhD = dVar;
        this.qhG = str;
        this.fzV = str2;
    }

    public final void run() {
        try {
            d.d(this.qhD).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.qhG + ")", null);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[]{this.fzV, e.getMessage()});
        }
    }
}
