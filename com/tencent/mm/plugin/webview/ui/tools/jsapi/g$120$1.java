package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.120;
import com.tencent.mm.sdk.platformtools.x;

class g$120$1 implements Runnable {
    final /* synthetic */ 120 qke;

    g$120$1(120 120) {
        this.qke = 120;
    }

    public final void run() {
        Runnable runnable = (Runnable) g.bYp().pollFirst();
        if (runnable != null) {
            runnable.run();
            return;
        }
        x.i("MicroMsg.MsgHandler", "authJsApiQueue processed!");
        g.bYq();
    }
}
