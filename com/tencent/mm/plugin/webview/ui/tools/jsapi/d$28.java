package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class d$28 implements Runnable {
    final /* synthetic */ d qhD;
    final /* synthetic */ String qhF;

    d$28(d dVar, String str) {
        this.qhD = dVar;
        this.qhF = str;
    }

    public final void run() {
        try {
            d.d(this.qhD).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.qhF + ")", null);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[]{e.getMessage()});
        }
    }
}
