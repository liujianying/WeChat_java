package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class d$54 implements Runnable {
    final /* synthetic */ d qhD;
    final /* synthetic */ String qhH;

    public d$54(d dVar, String str) {
        this.qhD = dVar;
        this.qhH = str;
    }

    public final void run() {
        try {
            d.d(this.qhD).evaluateJavascript(this.qhH, null);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[]{e.getMessage()});
        }
    }
}
