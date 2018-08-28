package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class g$52 implements Runnable {
    final /* synthetic */ g qiK;

    g$52(g gVar) {
        this.qiK = gVar;
    }

    public final void run() {
        if (g.x(this.qiK) != null) {
            g.x(this.qiK).c(g.y(this.qiK));
        }
        if (g.y(this.qiK) == null) {
            x.w("MicroMsg.MsgHandler", "already callback");
            return;
        }
        g.z(this.qiK);
        g.a(this.qiK, g.k(this.qiK), "geo_location:fail_timeout", null);
    }
}
