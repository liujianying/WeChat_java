package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class d$39 implements Runnable {
    final /* synthetic */ String fzV;
    final /* synthetic */ d qhD;

    public d$39(d dVar, String str) {
        this.qhD = dVar;
        this.fzV = str;
    }

    public final void run() {
        try {
            d.d(this.qhD).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fzV + ")", null);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, ex = %s", new Object[]{e.getMessage()});
        }
    }
}
